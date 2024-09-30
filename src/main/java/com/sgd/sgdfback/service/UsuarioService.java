package com.sgd.sgdfback.service;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.UsuarioRolDAO;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.model.UsuarioRol;
import com.sgd.sgdfback.object.usuario.UserResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRolDAO userRoleRepository;

    public UserResponse datosUser(Usuario user) {
        UsuarioRol userRole = userRoleRepository.findFirstByUserId(user.getId());

        String username = user.getUsername();
        String rol = userRole.getRole().getName().toString();
        String unidad = userRole.getUnidad().getNombre();
        String cif = user.getCif();

        return UserResponse.builder()
                .username(username)
                .rol(rol)
                .unidad(unidad)
                .cif(cif)
                .build();
    }
}
