package com.sgd.sgdfback.Models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 250)
    private RoleName name;

    private String codigo;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<Flujo> flujos;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<Seguimiento> seguimientos;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<User_Role> user_roles;

}