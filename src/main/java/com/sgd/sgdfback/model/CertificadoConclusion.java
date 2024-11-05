package com.sgd.sgdfback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    private String r_valorada;
    private String r_cedula_identidad;
    private String r_certificado_unico;

    private String c_certificado_conclusion;

    private String f_certificado_conclusion;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;

    public CertificadoConclusion() {
    }

    public CertificadoConclusion(Integer id, Integer user_id, Long cif, String d_valorada, String d_cedula_identidad, String d_certificado_unico, String d_certificado_conclusion, String r_valorada, String r_cedula_identidad, String r_certificado_unico, String c_certificado_conclusion, String f_certificado_conclusion, Tramite tramite) {
        this.id = id;
        this.user_id = user_id;
        this.cif = cif;
        this.d_valorada = d_valorada;
        this.d_cedula_identidad = d_cedula_identidad;
        this.d_certificado_unico = d_certificado_unico;
        this.d_certificado_conclusion = d_certificado_conclusion;
        this.r_valorada = r_valorada;
        this.r_cedula_identidad = r_cedula_identidad;
        this.r_certificado_unico = r_certificado_unico;
        this.c_certificado_conclusion = c_certificado_conclusion;
        this.f_certificado_conclusion = f_certificado_conclusion;
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

    public String getD_valorada() {
        return this.d_valorada;
    }

    public void setD_valorada(String d_valorada) {
        this.d_valorada = d_valorada;
    }

    public String getD_cedula_identidad() {
        return this.d_cedula_identidad;
    }

    public void setD_cedula_identidad(String d_cedula_identidad) {
        this.d_cedula_identidad = d_cedula_identidad;
    }

    public String getD_certificado_unico() {
        return this.d_certificado_unico;
    }

    public void setD_certificado_unico(String d_certificado_unico) {
        this.d_certificado_unico = d_certificado_unico;
    }

    public String getD_certificado_conclusion() {
        return this.d_certificado_conclusion;
    }

    public void setD_certificado_conclusion(String d_certificado_conclusion) {
        this.d_certificado_conclusion = d_certificado_conclusion;
    }

    public String getR_valorada() {
        return this.r_valorada;
    }

    public void setR_valorada(String r_valorada) {
        this.r_valorada = r_valorada;
    }

    public String getR_cedula_identidad() {
        return this.r_cedula_identidad;
    }

    public void setR_cedula_identidad(String r_cedula_identidad) {
        this.r_cedula_identidad = r_cedula_identidad;
    }

    public String getR_certificado_unico() {
        return this.r_certificado_unico;
    }

    public void setR_certificado_unico(String r_certificado_unico) {
        this.r_certificado_unico = r_certificado_unico;
    }

    public String getC_certificado_conclusion() {
        return this.c_certificado_conclusion;
    }

    public void setC_certificado_conclusion(String c_certificado_conclusion) {
        this.c_certificado_conclusion = c_certificado_conclusion;
    }

    public String getF_certificado_conclusion() {
        return this.f_certificado_conclusion;
    }

    public void setF_certificado_conclusion(String f_certificado_conclusion) {
        this.f_certificado_conclusion = f_certificado_conclusion;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }


}

