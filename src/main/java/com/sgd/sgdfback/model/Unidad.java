package com.sgd.sgdfback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "unidad")
public class Unidad {
    @Id
    private String id;
    private String nombre;
    @Column(nullable = false)
    private Integer secuencia = 0;

    @OneToMany(mappedBy = "unidad")
    @JsonIgnore
    private List<UsuarioRol> user_Roles;


    public Unidad() {
    }

    public Unidad(String id, String nombre, Integer secuencia, List<UsuarioRol> user_Roles) {
        this.id = id;
        this.nombre = nombre;
        this.secuencia = secuencia;
        this.user_Roles = user_Roles;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSecuencia() {
        return this.secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public List<UsuarioRol> getUser_Roles() {
        return this.user_Roles;
    }

    public void setUser_Roles(List<UsuarioRol> user_Roles) {
        this.user_Roles = user_Roles;
    }

}
