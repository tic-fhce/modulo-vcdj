package com.sgd.sgdfback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "designacion_tribunal")
public class DesignacionTribunal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;

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

    private String f_solicitud_tribunal;
    private String f_proyecto_resolucion_tribunal;
    private String f_resolucion_tribunal;

    @ManyToOne
    @JoinColumn(name = "aprobacion_perfil_id")
    private AprobacionPerfil aprobacion_Perfil;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;

    public DesignacionTribunal() {
    }

    public DesignacionTribunal(Integer id, Integer userId, Long cif, String d_nota_suficiencia_tutor, String d_trabajo_grado, String d_carta_conclusion_institucion, String d_solicitud_tribunal, String d_proyecto_resolucion_tribunal, String d_resolucion_tribunal, String r_nota_suficiencia_tutor, String r_trabajo_grado, String r_carta_conclusion_institucion, String c_solicitud_tribunal, String c_proyecto_resolucion_tribunal, String c_resolucion_tribunal, String f_solicitud_tribunal, String f_proyecto_resolucion_tribunal, String f_resolucion_tribunal, AprobacionPerfil aprobacion_Perfil, Tramite tramite) {
        this.id = id;
        this.userId = userId;
        this.cif = cif;
        this.d_nota_suficiencia_tutor = d_nota_suficiencia_tutor;
        this.d_trabajo_grado = d_trabajo_grado;
        this.d_carta_conclusion_institucion = d_carta_conclusion_institucion;
        this.d_solicitud_tribunal = d_solicitud_tribunal;
        this.d_proyecto_resolucion_tribunal = d_proyecto_resolucion_tribunal;
        this.d_resolucion_tribunal = d_resolucion_tribunal;
        this.r_nota_suficiencia_tutor = r_nota_suficiencia_tutor;
        this.r_trabajo_grado = r_trabajo_grado;
        this.r_carta_conclusion_institucion = r_carta_conclusion_institucion;
        this.c_solicitud_tribunal = c_solicitud_tribunal;
        this.c_proyecto_resolucion_tribunal = c_proyecto_resolucion_tribunal;
        this.c_resolucion_tribunal = c_resolucion_tribunal;
        this.f_solicitud_tribunal = f_solicitud_tribunal;
        this.f_proyecto_resolucion_tribunal = f_proyecto_resolucion_tribunal;
        this.f_resolucion_tribunal = f_resolucion_tribunal;
        this.aprobacion_Perfil = aprobacion_Perfil;
        this.tramite = tramite;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getCif() {
        return this.cif;
    }

    public void setCif(Long cif) {
        this.cif = cif;
    }

    public String getD_nota_suficiencia_tutor() {
        return this.d_nota_suficiencia_tutor;
    }

    public void setD_nota_suficiencia_tutor(String d_nota_suficiencia_tutor) {
        this.d_nota_suficiencia_tutor = d_nota_suficiencia_tutor;
    }

    public String getD_trabajo_grado() {
        return this.d_trabajo_grado;
    }

    public void setD_trabajo_grado(String d_trabajo_grado) {
        this.d_trabajo_grado = d_trabajo_grado;
    }

    public String getD_carta_conclusion_institucion() {
        return this.d_carta_conclusion_institucion;
    }

    public void setD_carta_conclusion_institucion(String d_carta_conclusion_institucion) {
        this.d_carta_conclusion_institucion = d_carta_conclusion_institucion;
    }

    public String getD_solicitud_tribunal() {
        return this.d_solicitud_tribunal;
    }

    public void setD_solicitud_tribunal(String d_solicitud_tribunal) {
        this.d_solicitud_tribunal = d_solicitud_tribunal;
    }

    public String getD_proyecto_resolucion_tribunal() {
        return this.d_proyecto_resolucion_tribunal;
    }

    public void setD_proyecto_resolucion_tribunal(String d_proyecto_resolucion_tribunal) {
        this.d_proyecto_resolucion_tribunal = d_proyecto_resolucion_tribunal;
    }

    public String getD_resolucion_tribunal() {
        return this.d_resolucion_tribunal;
    }

    public void setD_resolucion_tribunal(String d_resolucion_tribunal) {
        this.d_resolucion_tribunal = d_resolucion_tribunal;
    }

    public String getR_nota_suficiencia_tutor() {
        return this.r_nota_suficiencia_tutor;
    }

    public void setR_nota_suficiencia_tutor(String r_nota_suficiencia_tutor) {
        this.r_nota_suficiencia_tutor = r_nota_suficiencia_tutor;
    }

    public String getR_trabajo_grado() {
        return this.r_trabajo_grado;
    }

    public void setR_trabajo_grado(String r_trabajo_grado) {
        this.r_trabajo_grado = r_trabajo_grado;
    }

    public String getR_carta_conclusion_institucion() {
        return this.r_carta_conclusion_institucion;
    }

    public void setR_carta_conclusion_institucion(String r_carta_conclusion_institucion) {
        this.r_carta_conclusion_institucion = r_carta_conclusion_institucion;
    }

    public String getC_solicitud_tribunal() {
        return this.c_solicitud_tribunal;
    }

    public void setC_solicitud_tribunal(String c_solicitud_tribunal) {
        this.c_solicitud_tribunal = c_solicitud_tribunal;
    }

    public String getC_proyecto_resolucion_tribunal() {
        return this.c_proyecto_resolucion_tribunal;
    }

    public void setC_proyecto_resolucion_tribunal(String c_proyecto_resolucion_tribunal) {
        this.c_proyecto_resolucion_tribunal = c_proyecto_resolucion_tribunal;
    }

    public String getC_resolucion_tribunal() {
        return this.c_resolucion_tribunal;
    }

    public void setC_resolucion_tribunal(String c_resolucion_tribunal) {
        this.c_resolucion_tribunal = c_resolucion_tribunal;
    }

    public String getF_solicitud_tribunal() {
        return this.f_solicitud_tribunal;
    }

    public void setF_solicitud_tribunal(String f_solicitud_tribunal) {
        this.f_solicitud_tribunal = f_solicitud_tribunal;
    }

    public String getF_proyecto_resolucion_tribunal() {
        return this.f_proyecto_resolucion_tribunal;
    }

    public void setF_proyecto_resolucion_tribunal(String f_proyecto_resolucion_tribunal) {
        this.f_proyecto_resolucion_tribunal = f_proyecto_resolucion_tribunal;
    }

    public String getF_resolucion_tribunal() {
        return this.f_resolucion_tribunal;
    }

    public void setF_resolucion_tribunal(String f_resolucion_tribunal) {
        this.f_resolucion_tribunal = f_resolucion_tribunal;
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
