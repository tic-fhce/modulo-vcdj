package com.sgd.sgdfback.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "designacion_tribunal")
public class Designacion_Tribunal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user_id;

    private Long cif;
    
    private String d_nota_suficiencia_tutor;
    private String d_trabajo_grado;
    private String d_carta_conclusion_institucion;
    private String d_solicitud_tribunal;
    private String d_proyecto_resolucion_tribunal;
    private String d_resolucion_tribunal;

    private String r_nota_suficiencia_tutor;
    private String r_trabajo_grado;
    private String r_carta_conclusion_institucion;

    private String c_solicitud_tribunal;
    private String c_proyecto_resolucion_tribunal;
    private String c_resolucion_tribunal;

    @ManyToOne
    @JoinColumn(name = "aprobacion_perfil_id")
    private Aprobacion_Perfil aprobacion_Perfil;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;
}

