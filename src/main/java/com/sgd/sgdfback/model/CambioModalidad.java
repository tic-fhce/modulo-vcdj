package com.sgd.sgdfback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cambio_modalidad")
public class CambioModalidad {
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
    private AprobacionPerfil aprobacion_Perfil;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;

    public CambioModalidad() {
    }

    public CambioModalidad(Integer id, Integer user_id, Long cif, String cambio, String n_modalidad, String n_titulo, String n_tutor, String d_nota_director, String d_nota_tutor, String d_carta_institucion, String d_perfil_grado, String d_solicitud_aprobacion_perfil, String d_proyecto_resolucion_perfil, String d_resolucion_perfil, String r_nota_director, String r_nota_tutor, String r_carta_institucion, String r_perfil_grado, String c_solicitud_aprobacion_perfil, String c_proyecto_resolucion_perfil, String c_resolucion_perfil, AprobacionPerfil aprobacion_Perfil, Tramite tramite) {
        this.id = id;
        this.user_id = user_id;
        this.cif = cif;
        this.cambio = cambio;
        this.n_modalidad = n_modalidad;
        this.n_titulo = n_titulo;
        this.n_tutor = n_tutor;
        this.d_nota_director = d_nota_director;
        this.d_nota_tutor = d_nota_tutor;
        this.d_carta_institucion = d_carta_institucion;
        this.d_perfil_grado = d_perfil_grado;
        this.d_solicitud_aprobacion_perfil = d_solicitud_aprobacion_perfil;
        this.d_proyecto_resolucion_perfil = d_proyecto_resolucion_perfil;
        this.d_resolucion_perfil = d_resolucion_perfil;
        this.r_nota_director = r_nota_director;
        this.r_nota_tutor = r_nota_tutor;
        this.r_carta_institucion = r_carta_institucion;
        this.r_perfil_grado = r_perfil_grado;
        this.c_solicitud_aprobacion_perfil = c_solicitud_aprobacion_perfil;
        this.c_proyecto_resolucion_perfil = c_proyecto_resolucion_perfil;
        this.c_resolucion_perfil = c_resolucion_perfil;
        this.aprobacion_Perfil = aprobacion_Perfil;
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

    public String getCambio() {
        return this.cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getN_modalidad() {
        return this.n_modalidad;
    }

    public void setN_modalidad(String n_modalidad) {
        this.n_modalidad = n_modalidad;
    }

    public String getN_titulo() {
        return this.n_titulo;
    }

    public void setN_titulo(String n_titulo) {
        this.n_titulo = n_titulo;
    }

    public String getN_tutor() {
        return this.n_tutor;
    }

    public void setN_tutor(String n_tutor) {
        this.n_tutor = n_tutor;
    }

    public String getD_nota_director() {
        return this.d_nota_director;
    }

    public void setD_nota_director(String d_nota_director) {
        this.d_nota_director = d_nota_director;
    }

    public String getD_nota_tutor() {
        return this.d_nota_tutor;
    }

    public void setD_nota_tutor(String d_nota_tutor) {
        this.d_nota_tutor = d_nota_tutor;
    }

    public String getD_carta_institucion() {
        return this.d_carta_institucion;
    }

    public void setD_carta_institucion(String d_carta_institucion) {
        this.d_carta_institucion = d_carta_institucion;
    }

    public String getD_perfil_grado() {
        return this.d_perfil_grado;
    }

    public void setD_perfil_grado(String d_perfil_grado) {
        this.d_perfil_grado = d_perfil_grado;
    }

    public String getD_solicitud_aprobacion_perfil() {
        return this.d_solicitud_aprobacion_perfil;
    }

    public void setD_solicitud_aprobacion_perfil(String d_solicitud_aprobacion_perfil) {
        this.d_solicitud_aprobacion_perfil = d_solicitud_aprobacion_perfil;
    }

    public String getD_proyecto_resolucion_perfil() {
        return this.d_proyecto_resolucion_perfil;
    }

    public void setD_proyecto_resolucion_perfil(String d_proyecto_resolucion_perfil) {
        this.d_proyecto_resolucion_perfil = d_proyecto_resolucion_perfil;
    }

    public String getD_resolucion_perfil() {
        return this.d_resolucion_perfil;
    }

    public void setD_resolucion_perfil(String d_resolucion_perfil) {
        this.d_resolucion_perfil = d_resolucion_perfil;
    }

    public String getR_nota_director() {
        return this.r_nota_director;
    }

    public void setR_nota_director(String r_nota_director) {
        this.r_nota_director = r_nota_director;
    }

    public String getR_nota_tutor() {
        return this.r_nota_tutor;
    }

    public void setR_nota_tutor(String r_nota_tutor) {
        this.r_nota_tutor = r_nota_tutor;
    }

    public String getR_carta_institucion() {
        return this.r_carta_institucion;
    }

    public void setR_carta_institucion(String r_carta_institucion) {
        this.r_carta_institucion = r_carta_institucion;
    }

    public String getR_perfil_grado() {
        return this.r_perfil_grado;
    }

    public void setR_perfil_grado(String r_perfil_grado) {
        this.r_perfil_grado = r_perfil_grado;
    }

    public String getC_solicitud_aprobacion_perfil() {
        return this.c_solicitud_aprobacion_perfil;
    }

    public void setC_solicitud_aprobacion_perfil(String c_solicitud_aprobacion_perfil) {
        this.c_solicitud_aprobacion_perfil = c_solicitud_aprobacion_perfil;
    }

    public String getC_proyecto_resolucion_perfil() {
        return this.c_proyecto_resolucion_perfil;
    }

    public void setC_proyecto_resolucion_perfil(String c_proyecto_resolucion_perfil) {
        this.c_proyecto_resolucion_perfil = c_proyecto_resolucion_perfil;
    }

    public String getC_resolucion_perfil() {
        return this.c_resolucion_perfil;
    }

    public void setC_resolucion_perfil(String c_resolucion_perfil) {
        this.c_resolucion_perfil = c_resolucion_perfil;
    }

    public AprobacionPerfil getAprobacion_Perfil() {
        return this.aprobacion_Perfil;
    }

    public void setAprobacion_Perfil(AprobacionPerfil aprobacion_Perfil) {
        this.aprobacion_Perfil = aprobacion_Perfil;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

}
