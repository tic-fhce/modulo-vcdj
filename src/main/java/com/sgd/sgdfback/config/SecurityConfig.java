package com.sgd.sgdfback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, AuthenticationProvider authenticationProvider){
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authProvider = authenticationProvider;
    }

    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF
                .cors(withDefaults()) // Habilitar CORS con la configuración por defecto
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .antMatchers("/auth/**").permitAll() // Permitir el acceso sin autenticación a las rutas bajo /auth/**
                                .anyRequest().authenticated() // Requiere autenticación para cualquier otra ruta
                )
                .sessionManagement(sessionManager ->
                        sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Configurar la política de sesión como sin estado
                )
                .authenticationProvider(authProvider) // Configura el proveedor de autenticación
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Añadir el filtro JWT antes del filtro de autenticación por nombre de usuario y contraseña
                .build();
    }

}
