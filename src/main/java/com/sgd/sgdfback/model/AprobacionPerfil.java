package com.sgd.sgdfback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "aprobacion_perfil")
public class AprobacionPerfil {
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

    private String f_solicitud_aprobacion_perfil;
    private String f_proyecto_resolucion_perfil;
    private String f_resolucion_perfil;

    @OneToMany(mappedBy = "aprobacion_Perfil")
    @JsonIgnore
    private List<DesignacionTribunal> designacion_Tribunals;

    @OneToMany(mappedBy = "aprobacion_Perfil")
    @JsonIgnore
    private List<CambioModalidad> cambio_Modalidads;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;


    public AprobacionPerfil() {
    }


    public AprobacionPerfil(Integer id, Integer user_id, Long cif, String modalidad, String titulo, String tutor, String d_nota_director, String d_nota_tutor, String d_conclusion_estudios, String d_record_academico, String d_carta_institucion, String d_perfil_grado, String d_solicitud_aprobacion_perfil, String d_proyecto_resolucion_perfil, String d_resolucion_perfil, String r_nota_director, String r_nota_tutor, String r_conclusion_estudios, String r_record_academico, String r_carta_institucion, String r_perfil_grado, String c_solicitud_aprobacion_perfil, String c_proyecto_resolucion_perfil, String c_resolucion_perfil, String f_solicitud_aprobacion_perfil, String f_proyecto_resolucion_perfil, String f_resolucion_perfil, List<DesignacionTribunal> designacion_Tribunals, List<CambioModalidad> cambio_Modalidads, Tramite tramite) {
        this.id = id;
        this.user_id = user_id;
        this.cif = cif;
        this.modalidad = modalidad;
        this.titulo = titulo;
        this.tutor = tutor;
        this.d_nota_director = d_nota_director;
        this.d_nota_tutor = d_nota_tutor;
        this.d_conclusion_estudios = d_conclusion_estudios;
        this.d_record_academico = d_record_academico;
        this.d_carta_institucion = d_carta_institucion;
        this.d_perfil_grado = d_perfil_grado;
        this.d_solicitud_aprobacion_perfil = d_solicitud_aprobacion_perfil;
        this.d_proyecto_resolucion_perfil = d_proyecto_resolucion_perfil;
        this.d_resolucion_perfil = d_resolucion_perfil;
        this.r_nota_director = r_nota_director;
        this.r_nota_tutor = r_nota_tutor;
        this.r_conclusion_estudios = r_conclusion_estudios;
        this.r_record_academico = r_record_academico;
        this.r_carta_institucion = r_carta_institucion;
        this.r_perfil_grado = r_perfil_grado;
        this.c_solicitud_aprobacion_perfil = c_solicitud_aprobacion_perfil;
        this.c_proyecto_resolucion_perfil = c_proyecto_resolucion_perfil;
        this.c_resolucion_perfil = c_resolucion_perfil;
        this.f_solicitud_aprobacion_perfil = f_solicitud_aprobacion_perfil;
        this.f_proyecto_resolucion_perfil = f_proyecto_resolucion_perfil;
        this.f_resolucion_perfil = f_resolucion_perfil;
        this.designacion_Tribunals = designacion_Tribunals;
        this.cambio_Modalidads = cambio_Modalidads;
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

    public String getModalidad() {
        return this.modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTutor() {
        return this.tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
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

    public String getD_conclusion_estudios() {
        return this.d_conclusion_estudios;
    }

    public void setD_conclusion_estudios(String d_conclusion_estudios) {
        this.d_conclusion_estudios = d_conclusion_estudios;
    }

    public String getD_record_academico() {
        return this.d_record_academico;
    }

    public void setD_record_academico(String d_record_academico) {
        this.d_record_academico = d_record_academico;
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

    public String getR_conclusion_estudios() {
        return this.r_conclusion_estudios;
    }

    public void setR_conclusion_estudios(String r_conclusion_estudios) {
        this.r_conclusion_estudios = r_conclusion_estudios;
    }

    public String getR_record_academico() {
        return this.r_record_academico;
    }

    public void setR_record_academico(String r_record_academico) {
        this.r_record_academico = r_record_academico;
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

    public String getF_solicitud_aprobacion_perfil() {
        return this.f_solicitud_aprobacion_perfil;
    }

    public void setF_solicitud_aprobacion_perfil(String f_solicitud_aprobacion_perfil) {
        this.f_solicitud_aprobacion_perfil = f_solicitud_aprobacion_perfil;
    }

    public String getF_proyecto_resolucion_perfil() {
        return this.f_proyecto_resolucion_perfil;
    }

    public void setF_proyecto_resolucion_perfil(String f_proyecto_resolucion_perfil) {
        this.f_proyecto_resolucion_perfil = f_proyecto_resolucion_perfil;
    }

    public String getF_resolucion_perfil() {
        return this.f_resolucion_perfil;
    }

    public void setF_resolucion_perfil(String f_resolucion_perfil) {
        this.f_resolucion_perfil = f_resolucion_perfil;
    }

    public List<DesignacionTribunal> getDesignacion_Tribunals() {
        return this.designacion_Tribunals;
    }

    public void setDesignacion_Tribunals(List<DesignacionTribunal> designacion_Tribunals) {
        this.designacion_Tribunals = designacion_Tribunals;
    }

    public List<CambioModalidad> getCambio_Modalidads() {
        return this.cambio_Modalidads;
    }

    public void setCambio_Modalidads(List<CambioModalidad> cambio_Modalidads) {
        this.cambio_Modalidads = cambio_Modalidads;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }
    
}
