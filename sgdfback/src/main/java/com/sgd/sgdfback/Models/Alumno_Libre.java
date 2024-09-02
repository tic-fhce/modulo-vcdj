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
@Table(name = "alumno_libre")
public class Alumno_Libre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;
    private Long cif;

    private String d_solicitud;
    private String d_respaldo;
    private String d_proy_resolucion;
    private String d_resolucion;

    private String r_solicitud;
    private String r_respaldo;
    private String r_proy_resolucion;

    private String c_proy_resolucion;
    private String c_resolucion;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;

}
