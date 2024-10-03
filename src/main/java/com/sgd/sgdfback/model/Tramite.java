package com.sgd.sgdfback.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tramite")
public class Tramite {
    @Id
    private String id;
    private String flujo;
    private String proceso;
    private String tipo;
    private Integer user_id;
    private String carrera;
    @Column(columnDefinition = "VARCHAR(50) DEFAULT 'pendiente'")
    private String estado;
    private LocalDateTime creacion;

    @OneToMany(mappedBy = "tramite")
    private List<Seguimiento> seguimientos;

    @OneToMany(mappedBy = "tramite")
    private List<AprobacionPerfil> aprobacion_Perfils;

    @OneToMany(mappedBy = "tramite")
    private List<Convocatoria> convocatorias;
    
    @OneToMany(mappedBy = "tramite")
    private List<DesignacionTribunal> designacion_Tribunals;

    public Tramite(String id) {
        this.id = id;
    }


    public Tramite() {
    }

    public Tramite(String id, String flujo, String proceso, String tipo, Integer user_id, String carrera, String estado, LocalDateTime creacion, List<Seguimiento> seguimientos, List<AprobacionPerfil> aprobacion_Perfils, List<Convocatoria> convocatorias, List<DesignacionTribunal> designacion_Tribunals) {
        this.id = id;
        this.flujo = flujo;
        this.proceso = proceso;
        this.tipo = tipo;
        this.user_id = user_id;
        this.carrera = carrera;
        this.estado = estado;
        this.creacion = creacion;
        this.seguimientos = seguimientos;
        this.aprobacion_Perfils = aprobacion_Perfils;
        this.convocatorias = convocatorias;
        this.designacion_Tribunals = designacion_Tribunals;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlujo() {
        return this.flujo;
    }

    public void setFlujo(String flujo) {
        this.flujo = flujo;
    }

    public String getProceso() {
        return this.proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getCreacion() {
        return this.creacion;
    }

    public void setCreacion(LocalDateTime creacion) {
        this.creacion = creacion;
    }

    public List<Seguimiento> getSeguimientos() {
        return this.seguimientos;
    }

    public void setSeguimientos(List<Seguimiento> seguimientos) {
        this.seguimientos = seguimientos;
    }

    public List<AprobacionPerfil> getAprobacion_Perfils() {
        return this.aprobacion_Perfils;
    }

    public void setAprobacion_Perfils(List<AprobacionPerfil> aprobacion_Perfils) {
        this.aprobacion_Perfils = aprobacion_Perfils;
    }

    public List<Convocatoria> getConvocatorias() {
        return this.convocatorias;
    }

    public void setConvocatorias(List<Convocatoria> convocatorias) {
        this.convocatorias = convocatorias;
    }

    public List<DesignacionTribunal> getDesignacion_Tribunals() {
        return this.designacion_Tribunals;
    }

    public void setDesignacion_Tribunals(List<DesignacionTribunal> designacion_Tribunals) {
        this.designacion_Tribunals = designacion_Tribunals;
    }


}
