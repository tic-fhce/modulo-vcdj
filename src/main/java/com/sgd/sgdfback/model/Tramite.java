package com.sgd.sgdfback.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
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
    @JsonIgnore
    private List<Seguimiento> seguimientos;

    @OneToMany(mappedBy = "tramite")
    @JsonIgnore
    private List<AprobacionPerfil> aprobacion_Perfils;

    @OneToMany(mappedBy = "tramite")
    @JsonIgnore
    private List<ConvDocInterinos> convDocInterinos;
    
    @OneToMany(mappedBy = "tramite")
    @JsonIgnore
    private List<DesignacionTribunal> designacion_Tribunals;

    @OneToMany(mappedBy = "tramite")
    @JsonIgnore
    private List<ConvDocContratados> convDocContratados;

    @OneToMany(mappedBy = "tramite")
    @JsonIgnore
    private List<ConvAuxDocencia> convAuxDocencias;

    public Tramite(String id) {
        this.id = id;
    }


    public Tramite() {
    }
    
}
