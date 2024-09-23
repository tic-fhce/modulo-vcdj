package com.sgd.sgdfback.Models;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seguimiento")
public class Seguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String flujo;
    private String proceso;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private String estado;
    private String comentario;
    private String carrera;
    @Column(columnDefinition = "VARCHAR(6) DEFAULT 'false'")
    private String visto;
    private LocalDateTime tiempo;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
