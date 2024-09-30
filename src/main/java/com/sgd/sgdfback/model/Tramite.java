package com.sgd.sgdfback.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
