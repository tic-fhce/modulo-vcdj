package com.sgd.sgdfback.service;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.UsuarioRolDAO;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.model.UsuarioRol;
import com.sgd.sgdfback.object.UsuarioDatosResponse;

@Service
public class UsuarioService {

    private final UsuarioRolDAO userRoleRepository;

    public UsuarioService(UsuarioRolDAO userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UsuarioDatosResponse datosUser(Usuario user) {
        UsuarioRol userRole = userRoleRepository.findFirstByUserId(user.getId());

        String username = user.getUsername();
        String rol = userRole.getRole().getName().toString();
        String unidad = userRole.getUnidad().getNombre();
        String cif = user.getCif();

        return new UsuarioDatosResponse.builder()
                .username(username)
                .rol(rol)
                .unidad(unidad)
                .cif(cif)
                .build();
    }
}
