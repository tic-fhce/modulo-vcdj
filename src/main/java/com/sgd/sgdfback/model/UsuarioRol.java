package com.sgd.sgdfback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_role")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Rol role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user;

    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private Unidad unidad;

    @OneToMany(mappedBy = "usuarioRol")
    private List<Seguimiento> seguimientos;


    public UsuarioRol() {
    }


    public UsuarioRol(Integer id, Rol role, Usuario user, Unidad unidad, List<Seguimiento> seguimientos) {
        this.id = id;
        this.role = role;
        this.user = user;
        this.unidad = unidad;
        this.seguimientos = seguimientos;
    }
    

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rol getRole() {
        return this.role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

    public Usuario getUser() {
        return this.user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Unidad getUnidad() {
        return this.unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public List<Seguimiento> getSeguimientos() {
        return this.seguimientos;
    }

    public void setSeguimientos(List<Seguimiento> seguimientos) {
        this.seguimientos = seguimientos;
    }

}
