package com.sgd.sgdfback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "certificado_unico")
public class CertificadoUnico {
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

    public CertificadoUnico() {
    }

    public CertificadoUnico(Integer id, Integer user_id, Long cif, String d_valorada, String d_cedula_identidad, String d_certificado_unico, String c_certificado_unico, Tramite tramite) {
        this.id = id;
        this.user_id = user_id;
        this.cif = cif;
        this.d_valorada = d_valorada;
        this.d_cedula_identidad = d_cedula_identidad;
        this.d_certificado_unico = d_certificado_unico;
        this.c_certificado_unico = c_certificado_unico;
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

    public String getC_certificado_unico() {
        return this.c_certificado_unico;
    }

    public void setC_certificado_unico(String c_certificado_unico) {
        this.c_certificado_unico = c_certificado_unico;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

}
