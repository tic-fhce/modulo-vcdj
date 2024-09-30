package com.sgd.sgdfback.object.auth;

import java.time.LocalDate;

import com.sgd.sgdfback.model.RolNombre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String sexo;
    LocalDate fecha_nac;
    String carrera;
    String email;
    String password; 
    RolNombre rol;
}
