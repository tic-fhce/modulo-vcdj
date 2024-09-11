package com.sgd.sgdfback.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aprobacion_perfil")
public class Aprobacion_Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user_id;

    private Long cif;
    private String modalidad;
    private String titulo;
    private String tutor;
    
    private String d_nota_director;
    private String d_nota_tutor;
    private String d_conclusion_estudios;
    private String d_record_academico;
    private String d_carta_institucion;
    private String d_perfil_grado;
    private String d_solicitud_aprobacion_perfil;
    private String d_proyecto_resolucion_perfil;
    private String d_resolucion_perfil;

    private String r_nota_director;
    private String r_nota_tutor;
    private String r_conclusion_estudios;
    private String r_record_academico;
    private String r_carta_institucion;
    private String r_perfil_grado;
    private String c_solicitud_aprobacion_perfil;
    private String c_proyecto_resolucion_perfil;
    private String c_resolucion_perfil;

    @OneToMany(mappedBy = "aprobacion_Perfil")
    private List<Designacion_Tribunal> designacion_Tribunals;

    @OneToMany(mappedBy = "aprobacion_Perfil")
    private List<Cambio_Modalidad> cambio_Modalidads;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;
}
