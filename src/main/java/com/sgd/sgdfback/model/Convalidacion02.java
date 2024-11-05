package com.sgd.sgdfback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    private String f_informe_convalidacion;
    private String f_proy_resolucion;
    private String f_resolucion;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;


    public Convalidacion02() {
    }

    public Convalidacion02(Integer id, Integer user_id, Long cif, String d_nota_director, String d_cedula_identidad, String d_record_academico_carrera_origen, String d_contenidos_analiticos, String d_formulario_convalidacion, String d_informe_convalidacion, String d_proy_resolucion, String d_resolucion, String r_nota_director, String r_cedula_identidad, String r_record_academico_carrera_origen, String r_contenidos_analiticos, String r_formulario_convalidacion, String r_informe_convalidacion, String r_proy_resolucion, String c_informe_convalidacion, String c_proy_resolucion, String c_resolucion, String f_informe_convalidacion, String f_proy_resolucion, String f_resolucion, Tramite tramite) {
        this.id = id;
        this.user_id = user_id;
        this.cif = cif;
        this.d_nota_director = d_nota_director;
        this.d_cedula_identidad = d_cedula_identidad;
        this.d_record_academico_carrera_origen = d_record_academico_carrera_origen;
        this.d_contenidos_analiticos = d_contenidos_analiticos;
        this.d_formulario_convalidacion = d_formulario_convalidacion;
        this.d_informe_convalidacion = d_informe_convalidacion;
        this.d_proy_resolucion = d_proy_resolucion;
        this.d_resolucion = d_resolucion;
        this.r_nota_director = r_nota_director;
        this.r_cedula_identidad = r_cedula_identidad;
        this.r_record_academico_carrera_origen = r_record_academico_carrera_origen;
        this.r_contenidos_analiticos = r_contenidos_analiticos;
        this.r_formulario_convalidacion = r_formulario_convalidacion;
        this.r_informe_convalidacion = r_informe_convalidacion;
        this.r_proy_resolucion = r_proy_resolucion;
        this.c_informe_convalidacion = c_informe_convalidacion;
        this.c_proy_resolucion = c_proy_resolucion;
        this.c_resolucion = c_resolucion;
        this.f_informe_convalidacion = f_informe_convalidacion;
        this.f_proy_resolucion = f_proy_resolucion;
        this.f_resolucion = f_resolucion;
        this.tramite = tramite;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Long getCif() {
        return this.cif;
    }

    public void setCif(Long cif) {
        this.cif = cif;
    }

    public String getD_nota_director() {
        return this.d_nota_director;
    }

    public void setD_nota_director(String d_nota_director) {
        this.d_nota_director = d_nota_director;
    }

    public String getD_cedula_identidad() {
        return this.d_cedula_identidad;
    }

    public void setD_cedula_identidad(String d_cedula_identidad) {
        this.d_cedula_identidad = d_cedula_identidad;
    }

    public String getD_record_academico_carrera_origen() {
        return this.d_record_academico_carrera_origen;
    }

    public void setD_record_academico_carrera_origen(String d_record_academico_carrera_origen) {
        this.d_record_academico_carrera_origen = d_record_academico_carrera_origen;
    }

    public String getD_contenidos_analiticos() {
        return this.d_contenidos_analiticos;
    }

    public void setD_contenidos_analiticos(String d_contenidos_analiticos) {
        this.d_contenidos_analiticos = d_contenidos_analiticos;
    }

    public String getD_formulario_convalidacion() {
        return this.d_formulario_convalidacion;
    }

    public void setD_formulario_convalidacion(String d_formulario_convalidacion) {
        this.d_formulario_convalidacion = d_formulario_convalidacion;
    }

    public String getD_informe_convalidacion() {
        return this.d_informe_convalidacion;
    }

    public void setD_informe_convalidacion(String d_informe_convalidacion) {
        this.d_informe_convalidacion = d_informe_convalidacion;
    }

    public String getD_proy_resolucion() {
        return this.d_proy_resolucion;
    }

    public void setD_proy_resolucion(String d_proy_resolucion) {
        this.d_proy_resolucion = d_proy_resolucion;
    }

    public String getD_resolucion() {
        return this.d_resolucion;
    }

    public void setD_resolucion(String d_resolucion) {
        this.d_resolucion = d_resolucion;
    }

    public String getR_nota_director() {
        return this.r_nota_director;
    }

    public void setR_nota_director(String r_nota_director) {
        this.r_nota_director = r_nota_director;
    }

    public String getR_cedula_identidad() {
        return this.r_cedula_identidad;
    }

    public void setR_cedula_identidad(String r_cedula_identidad) {
        this.r_cedula_identidad = r_cedula_identidad;
    }

    public String getR_record_academico_carrera_origen() {
        return this.r_record_academico_carrera_origen;
    }

    public void setR_record_academico_carrera_origen(String r_record_academico_carrera_origen) {
        this.r_record_academico_carrera_origen = r_record_academico_carrera_origen;
    }

    public String getR_contenidos_analiticos() {
        return this.r_contenidos_analiticos;
    }

    public void setR_contenidos_analiticos(String r_contenidos_analiticos) {
        this.r_contenidos_analiticos = r_contenidos_analiticos;
    }

    public String getR_formulario_convalidacion() {
        return this.r_formulario_convalidacion;
    }

    public void setR_formulario_convalidacion(String r_formulario_convalidacion) {
        this.r_formulario_convalidacion = r_formulario_convalidacion;
    }

    public String getR_informe_convalidacion() {
        return this.r_informe_convalidacion;
    }

    public void setR_informe_convalidacion(String r_informe_convalidacion) {
        this.r_informe_convalidacion = r_informe_convalidacion;
    }

    public String getR_proy_resolucion() {
        return this.r_proy_resolucion;
    }

    public void setR_proy_resolucion(String r_proy_resolucion) {
        this.r_proy_resolucion = r_proy_resolucion;
    }

    public String getC_informe_convalidacion() {
        return this.c_informe_convalidacion;
    }

    public void setC_informe_convalidacion(String c_informe_convalidacion) {
        this.c_informe_convalidacion = c_informe_convalidacion;
    }

    public String getC_proy_resolucion() {
        return this.c_proy_resolucion;
    }

    public void setC_proy_resolucion(String c_proy_resolucion) {
        this.c_proy_resolucion = c_proy_resolucion;
    }

    public String getC_resolucion() {
        return this.c_resolucion;
    }

    public void setC_resolucion(String c_resolucion) {
        this.c_resolucion = c_resolucion;
    }

    public String getF_informe_convalidacion() {
        return this.f_informe_convalidacion;
    }

    public void setF_informe_convalidacion(String f_informe_convalidacion) {
        this.f_informe_convalidacion = f_informe_convalidacion;
    }

    public String getF_proy_resolucion() {
        return this.f_proy_resolucion;
    }

    public void setF_proy_resolucion(String f_proy_resolucion) {
        this.f_proy_resolucion = f_proy_resolucion;
    }

    public String getF_resolucion() {
        return this.f_resolucion;
    }

    public void setF_resolucion(String f_resolucion) {
        this.f_resolucion = f_resolucion;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

}
