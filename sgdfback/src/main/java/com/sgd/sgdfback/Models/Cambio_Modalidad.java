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
@Table(name = "cambio_modalidad")
public class Cambio_Modalidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user_id;

    private Long cif;
    private String cambio;
    private String n_modalidad;
    private String n_titulo;
    private String n_tutor;
    
    private String d_nota_director;
    private String d_nota_tutor;
    private String d_carta_institucion;
    private String d_perfil_grado;
    private String d_solicitud_aprobacion_perfil;
    private String d_proyecto_resolucion_perfil;
    private String d_resolucion_perfil;

    private String r_nota_director;
    private String r_nota_tutor;
    private String r_carta_institucion;
    private String r_perfil_grado;
    private String c_solicitud_aprobacion_perfil;
    private String c_proyecto_resolucion_perfil;
    private String c_resolucion_perfil;

    @ManyToOne
    @JoinColumn(name = "aprobacion_perfil_id")
    private Aprobacion_Perfil aprobacion_Perfil;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;
}
