package com.sgd.sgdfback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.object.usuario.UserResponse;
import com.sgd.sgdfback.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UsuarioController {

    private final UsuarioService userService;

    @GetMapping
    public ResponseEntity<UserResponse> getCurrentUser(@AuthenticationPrincipal Usuario user) {
        return ResponseEntity.ok(userService.datosUser(user));
    }
}
