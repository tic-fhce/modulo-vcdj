package com.sgd.sgdfback.Controller._01_Auth;

import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sgd.sgdfback.Configurations.Jwt.JwtService;
import com.sgd.sgdfback.Models.Role;
import com.sgd.sgdfback.Models.Unidad;
import com.sgd.sgdfback.Models.User;
import com.sgd.sgdfback.Models.User_Role;
import com.sgd.sgdfback.Repositories.RoleRepository;
import com.sgd.sgdfback.Repositories.UnidadRepository;
import com.sgd.sgdfback.Repositories.UserRepository;
import com.sgd.sgdfback.Repositories.UserRoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final UnidadRepository unidadRepository;

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername())
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

        Integer existingUsers = userRepository.countByCif(sexo+fecha);
        String nro = String.format("%02d", existingUsers);

        String cif = sexo + fecha + nro;
    
        Role role = roleRepository.findByName(request.getRol())
        .orElseThrow(() -> new RuntimeException("Role no encontrado"));

        Unidad unidad = unidadRepository.findByNombre(request.getCarrera())
        .orElseThrow(() -> new RuntimeException("Unidad desconocida"));

        User user = User.builder()
                .cif(cif)
                .username(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);

        User_Role uRole = new User_Role();
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
