package com.sgd.sgdfback.Controller._01_Auth;

import java.time.LocalDate;

import com.sgd.sgdfback.Models.RoleName;

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
    RoleName rol;
}
