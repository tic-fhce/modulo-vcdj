package com.sgd.sgdfback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgd.sgdfback.object.AuthTokenResponse;
import com.sgd.sgdfback.object.AuthLoginRequest;
import com.sgd.sgdfback.object.AuthRegisterRequest;
import com.sgd.sgdfback.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthTokenResponse> login(@RequestBody AuthLoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthTokenResponse> register(@RequestBody AuthRegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
}
