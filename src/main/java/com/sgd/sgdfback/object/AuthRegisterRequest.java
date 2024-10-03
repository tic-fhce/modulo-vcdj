package com.sgd.sgdfback.object;

import java.time.LocalDate;

import com.sgd.sgdfback.model.RolNombre;

public class AuthRegisterRequest {
    private String sexo;
    private LocalDate fecha_nac;
    private String carrera;
    private String email;
    private String password; 
    private RolNombre rol;


    public AuthRegisterRequest() {
    }

    public AuthRegisterRequest(String sexo, LocalDate fecha_nac, String carrera, String email, String password, RolNombre rol) {
        this.sexo = sexo;
        this.fecha_nac = fecha_nac;
        this.carrera = carrera;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFecha_nac() {
        return this.fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolNombre getRol() {
        return this.rol;
    }

    public void setRol(RolNombre rol) {
        this.rol = rol;
    }

}
