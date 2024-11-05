package com.sgd.sgdfback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alumno_libre")
public class AlumnoLibre {
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

    private String f_proy_resolucion;
    private String f_resolucion;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;


    public AlumnoLibre() {
    }

    public AlumnoLibre(Integer id, Integer user_id, Long cif, String d_solicitud, String d_respaldo, String d_proy_resolucion, String d_resolucion, String r_solicitud, String r_respaldo, String r_proy_resolucion, String c_proy_resolucion, String c_resolucion, String f_proy_resolucion, String f_resolucion, Tramite tramite) {
        this.id = id;
        this.user_id = user_id;
        this.cif = cif;
        this.d_solicitud = d_solicitud;
        this.d_respaldo = d_respaldo;
        this.d_proy_resolucion = d_proy_resolucion;
        this.d_resolucion = d_resolucion;
        this.r_solicitud = r_solicitud;
        this.r_respaldo = r_respaldo;
        this.r_proy_resolucion = r_proy_resolucion;
        this.c_proy_resolucion = c_proy_resolucion;
        this.c_resolucion = c_resolucion;
        this.f_proy_resolucion = f_proy_resolucion;
        this.f_resolucion = f_resolucion;
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

    public String getR_proy_resolucion() {
        return this.r_proy_resolucion;
    }

    public void setR_proy_resolucion(String r_proy_resolucion) {
        this.r_proy_resolucion = r_proy_resolucion;
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

    public String getF_proy_resolucion() {
        return this.f_proy_resolucion;
    }

    public void setF_proy_resolucion(String f_proy_resolucion) {
        this.f_proy_resolucion = f_proy_resolucion;
    }

    public String getF_resolucion() {
        return this.f_resolucion;
    }

    public void setF_resolucion(String f_resolucion) {
        this.f_resolucion = f_resolucion;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }
    
}
