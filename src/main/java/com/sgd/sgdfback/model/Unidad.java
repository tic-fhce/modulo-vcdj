package com.sgd.sgdfback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
