package com.sgd.sgdfback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "concurso_doc_interinos")
public class ConcursoDocentesInterinos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;
    private Long cif;

    private String d_solicitud;
    private String d_respaldo;
    private String d_nota_vic;
    private String d_informe_conv;
    private String d_informe_obs;

    private String c_nota_vic;
    private String c_informe_conv;
    private String c_informe_obs;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;

    public ConcursoDocentesInterinos() {
    }

    public ConcursoDocentesInterinos(Integer id, Integer user_id, Long cif, String d_solicitud, String d_respaldo, String d_nota_vic, String d_informe_conv, String d_informe_obs, String c_nota_vic, String c_informe_conv, String c_informe_obs, Tramite tramite) {
        this.id = id;
        this.user_id = user_id;
        this.cif = cif;
        this.d_solicitud = d_solicitud;
        this.d_respaldo = d_respaldo;
        this.d_nota_vic = d_nota_vic;
        this.d_informe_conv = d_informe_conv;
        this.d_informe_obs = d_informe_obs;
        this.c_nota_vic = c_nota_vic;
        this.c_informe_conv = c_informe_conv;
        this.c_informe_obs = c_informe_obs;
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

    public String getD_nota_vic() {
        return this.d_nota_vic;
    }

    public void setD_nota_vic(String d_nota_vic) {
        this.d_nota_vic = d_nota_vic;
    }

    public String getD_informe_conv() {
        return this.d_informe_conv;
    }

    public void setD_informe_conv(String d_informe_conv) {
        this.d_informe_conv = d_informe_conv;
    }

    public String getD_informe_obs() {
        return this.d_informe_obs;
    }

    public void setD_informe_obs(String d_informe_obs) {
        this.d_informe_obs = d_informe_obs;
    }

    public String getC_nota_vic() {
        return this.c_nota_vic;
    }

    public void setC_nota_vic(String c_nota_vic) {
        this.c_nota_vic = c_nota_vic;
    }

    public String getC_informe_conv() {
        return this.c_informe_conv;
    }

    public void setC_informe_conv(String c_informe_conv) {
        this.c_informe_conv = c_informe_conv;
    }

    public String getC_informe_obs() {
        return this.c_informe_obs;
    }

    public void setC_informe_obs(String c_informe_obs) {
        this.c_informe_obs = c_informe_obs;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

}
