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
@Table(name = "certificado_unico")
public class Certificado_Unico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;
    private Long cif;

    private String d_valorada;
    private String d_cedula_identidad;
    private String d_certificado_unico;

    private String c_certificado_unico;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;
}
