package com.sgd.sgdfback.Models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

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
    private List<User_Role> user_Roles;
}
