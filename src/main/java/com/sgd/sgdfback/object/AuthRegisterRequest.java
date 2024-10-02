package com.sgd.sgdfback.object;

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
public class AuthRegisterRequest {
    String sexo;
    LocalDate fecha_nac;
    String carrera;
    String email;
    String password; 
    RolNombre rol;
}
