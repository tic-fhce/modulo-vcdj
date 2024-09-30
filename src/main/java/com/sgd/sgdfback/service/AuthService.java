package com.sgd.sgdfback.service;

import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sgd.sgdfback.config.Jwt.JwtService;
import com.sgd.sgdfback.dao.RolDAO;
import com.sgd.sgdfback.dao.UnidadDAO;
import com.sgd.sgdfback.dao.UsuarioDAO;
import com.sgd.sgdfback.dao.UsuarioRolDAO;
import com.sgd.sgdfback.model.Rol;
import com.sgd.sgdfback.model.Unidad;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.model.UsuarioRol;
import com.sgd.sgdfback.object.auth.AuthResponse;
import com.sgd.sgdfback.object.auth.LoginRequest;
import com.sgd.sgdfback.object.auth.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

        private final UsuarioDAO userRepository;
        private final RolDAO roleRepository;
        private final UsuarioRolDAO userRoleRepository;
        private final UnidadDAO unidadRepository;

        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public AuthResponse login(LoginRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
                Usuario user = userRepository.findByUsername(request.getUsername())
                                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
                String token = jwtService.getToken(user);
                return AuthResponse.builder()
                                .token(token)
                                .build();
        }

        public AuthResponse register(RegisterRequest request) {
                String sexo = request.getSexo().equalsIgnoreCase("M") ? "1" : "2";

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                String fecha = request.getFecha_nac().format(formatter);

                Integer existingUsers = userRepository.countByCif(sexo + fecha);
                String nro = String.format("%02d", existingUsers);

                String cif = sexo + fecha + nro;

                Rol role = roleRepository.findByName(request.getRol())
                                .orElseThrow(() -> new RuntimeException("Role no encontrado"));

                Unidad unidad = unidadRepository.findByNombre(request.getCarrera())
                                .orElseThrow(() -> new RuntimeException("Unidad desconocida"));

                Usuario user = Usuario.builder()
                                .cif(cif)
                                .username(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .build();
                userRepository.save(user);

                UsuarioRol uRole = new UsuarioRol();
                uRole.setUser(user);
                uRole.setRole(role);
                uRole.setUnidad(unidad);
                userRoleRepository.save(uRole);

                // Crear y devolver la respuesta de autenticación
                return AuthResponse.builder()
                                .token(jwtService.getToken(user))
                                .build();
        }

}
