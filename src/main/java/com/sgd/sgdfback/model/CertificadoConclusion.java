package com.sgd.sgdfback.model;

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
@Table(name = "certificado_conclusion")
public class CertificadoConclusion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;
    private Long cif;

    private String d_valorada;
    private String d_cedula_identidad;
    private String d_certificado_unico;
    private String d_certificado_conclusion;

    private String c_certificado_conclusion;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;
}

