package com.sgd.sgdfback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 250)
    private RolNombre name;

    private String codigo;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<Flujo> flujos;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<UsuarioRol> user_roles;

    public Rol() {
    }

    public Rol(Integer id, RolNombre name, String codigo, List<Flujo> flujos, List<UsuarioRol> user_roles) {
        this.id = id;
        this.name = name;
        this.codigo = codigo;
        this.flujos = flujos;
        this.user_roles = user_roles;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RolNombre getName() {
        return this.name;
    }

    public void setName(RolNombre name) {
        this.name = name;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Flujo> getFlujos() {
        return this.flujos;
    }

    public void setFlujos(List<Flujo> flujos) {
        this.flujos = flujos;
    }

    public List<UsuarioRol> getUser_roles() {
        return this.user_roles;
    }

    public void setUser_roles(List<UsuarioRol> user_roles) {
        this.user_roles = user_roles;
    }
    

}