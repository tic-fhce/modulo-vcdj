package com.sgd.sgdfback.Models;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "convocatoria")
public class Convocatoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user_id;

    private Long cif;
    private String tipo;

    private String d_convocatoria;
    private String d_nota_atencion;
    private String d_certificacion_carga_horaria;

    private String r_convocatoria;
    private String r_certificacion_carga_horaria;

    private String c_convocatoria;
    private String c_nota_atencion;
    private String c_certificacion_carga_horaria;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;
}
