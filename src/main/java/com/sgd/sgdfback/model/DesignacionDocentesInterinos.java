package com.sgd.sgdfback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "designacion_doc_interinos")
public class DesignacionDocentesInterinos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;
    private Long cif;

    private String d_faltantes; //temporalmente
    private String d_proy_resolucion;
    private String d_resolucion;

    private String c_proy_resolucion;
    private String c_resolucion;

    private String r_proy_resolucion;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;


    public DesignacionDocentesInterinos() {
    }

    public DesignacionDocentesInterinos(Integer id, Integer user_id, Long cif, String d_faltantes, String d_proy_resolucion, String d_resolucion, String c_proy_resolucion, String c_resolucion, String r_proy_resolucion, Tramite tramite) {
        this.id = id;
        this.user_id = user_id;
        this.cif = cif;
        this.d_faltantes = d_faltantes;
        this.d_proy_resolucion = d_proy_resolucion;
        this.d_resolucion = d_resolucion;
        this.c_proy_resolucion = c_proy_resolucion;
        this.c_resolucion = c_resolucion;
        this.r_proy_resolucion = r_proy_resolucion;
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

    public String getD_faltantes() {
        return this.d_faltantes;
    }

    public void setD_faltantes(String d_faltantes) {
        this.d_faltantes = d_faltantes;
    }

    public String getD_proy_resolucion() {
        return this.d_proy_resolucion;
    }

    public void setD_proy_resolucion(String d_proy_resolucion) {
        this.d_proy_resolucion = d_proy_resolucion;
    }

    public String getD_resolucion() {
        return this.d_resolucion;
    }

    public void setD_resolucion(String d_resolucion) {
        this.d_resolucion = d_resolucion;
    }

    public String getC_proy_resolucion() {
        return this.c_proy_resolucion;
    }

    public void setC_proy_resolucion(String c_proy_resolucion) {
        this.c_proy_resolucion = c_proy_resolucion;
    }

    public String getC_resolucion() {
        return this.c_resolucion;
    }

    public void setC_resolucion(String c_resolucion) {
        this.c_resolucion = c_resolucion;
    }

    public String getR_proy_resolucion() {
        return this.r_proy_resolucion;
    }

    public void setR_proy_resolucion(String r_proy_resolucion) {
        this.r_proy_resolucion = r_proy_resolucion;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

}
