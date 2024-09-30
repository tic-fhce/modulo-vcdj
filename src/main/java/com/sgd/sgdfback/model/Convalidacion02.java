package com.sgd.sgdfback.model;

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
@Table(name = "convalidacion_02")
public class Convalidacion02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;
    private Long cif;

    private String d_nota_director;
    private String d_cedula_identidad;
    private String d_record_academico_carrera_origen;
    private String d_contenidos_analiticos;
    private String d_formulario_convalidacion;
    private String d_informe_convalidacion;
    private String d_proy_resolucion;
    private String d_resolucion;

    private String r_nota_director;
    private String r_cedula_identidad;
    private String r_record_academico_carrera_origen;
    private String r_contenidos_analiticos;
    private String r_formulario_convalidacion;
    private String r_informe_convalidacion;
    private String r_proy_resolucion;

    private String c_informe_convalidacion;
    private String c_proy_resolucion;
    private String c_resolucion;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;
}
