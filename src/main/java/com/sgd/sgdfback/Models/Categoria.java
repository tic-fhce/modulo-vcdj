package com.sgd.sgdfback.Models;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    private String id;
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Flujo> flujos;
}
