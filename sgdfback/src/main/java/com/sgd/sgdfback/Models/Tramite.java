package com.sgd.sgdfback.Models;

import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.*;

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
    private List<Aprobacion_Perfil> aprobacion_Perfils;

    @OneToMany(mappedBy = "tramite")
    private List<Convocatoria> convocatorias;
    
    @OneToMany(mappedBy = "tramite")
    private List<Designacion_Tribunal> designacion_Tribunals;



}
