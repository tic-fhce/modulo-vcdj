package com.sgd.sgdfback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "materia_extra")
public class MateriaExtra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;
    private Long cif;

    private String d_solicitud;
    private String d_respaldo;
    private String d_aval;

    private String r_solicitud;
    private String r_respaldo;

    private String c_aval;

    private String f_aval;
    

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;

    public MateriaExtra() {
    }

    public MateriaExtra(Integer id, Integer user_id, Long cif, String d_solicitud, String d_respaldo, String d_aval, String r_solicitud, String r_respaldo, String c_aval, String f_aval, Tramite tramite) {
        this.id = id;
        this.user_id = user_id;
        this.cif = cif;
        this.d_solicitud = d_solicitud;
        this.d_respaldo = d_respaldo;
        this.d_aval = d_aval;
        this.r_solicitud = r_solicitud;
        this.r_respaldo = r_respaldo;
        this.c_aval = c_aval;
        this.f_aval = f_aval;
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

    public String getD_solicitud() {
        return this.d_solicitud;
    }

    public void setD_solicitud(String d_solicitud) {
        this.d_solicitud = d_solicitud;
    }

    public String getD_respaldo() {
        return this.d_respaldo;
    }

    public void setD_respaldo(String d_respaldo) {
        this.d_respaldo = d_respaldo;
    }

    public String getD_aval() {
        return this.d_aval;
    }

    public void setD_aval(String d_aval) {
        this.d_aval = d_aval;
    }

    public String getR_solicitud() {
        return this.r_solicitud;
    }

    public void setR_solicitud(String r_solicitud) {
        this.r_solicitud = r_solicitud;
    }

    public String getR_respaldo() {
        return this.r_respaldo;
    }

    public void setR_respaldo(String r_respaldo) {
        this.r_respaldo = r_respaldo;
    }

    public String getC_aval() {
        return this.c_aval;
    }

    public void setC_aval(String c_aval) {
        this.c_aval = c_aval;
    }

    public String getF_aval() {
        return this.f_aval;
    }

    public void setF_aval(String f_aval) {
        this.f_aval = f_aval;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

}