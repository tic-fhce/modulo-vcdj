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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private List<Seguimiento> seguimientos;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<UsuarioRol> user_roles;

}