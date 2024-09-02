package com.sgd.sgdfback.Controller._02_User;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.Models.User;
import com.sgd.sgdfback.Models.User_Role;
import com.sgd.sgdfback.Repositories.UserRoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRoleRepository userRoleRepository;

     public UserResponse datosUser(User user){
        User_Role userRole = userRoleRepository.findFirstByUserId(user.getId());

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
