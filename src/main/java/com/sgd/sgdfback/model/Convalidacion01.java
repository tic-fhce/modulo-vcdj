package com.sgd.sgdfback.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "convalidacion_01")
public class Convalidacion01 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;
    private Long cif;

    private String d_nota_director;
    private String d_cedula_identidad;
    private String d_record_academico;
    private String d_informe_convalidacion;

    private String r_nota_director;
    private String r_cedula_identidad;
    private String r_record_academico;
    private String r_informe_convalidacion;

    private String c_informe_convalidacion;

    private String f_informe_convalidacion;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;


    public Convalidacion01() {
    }

    public Convalidacion01(Integer id, Integer user_id, Long cif, String d_nota_director, String d_cedula_identidad, String d_record_academico, String d_informe_convalidacion, String r_nota_director, String r_cedula_identidad, String r_record_academico, String r_informe_convalidacion, String c_informe_convalidacion, String f_informe_convalidacion, Tramite tramite) {
        this.id = id;
        this.user_id = user_id;
        this.cif = cif;
        this.d_nota_director = d_nota_director;
        this.d_cedula_identidad = d_cedula_identidad;
        this.d_record_academico = d_record_academico;
        this.d_informe_convalidacion = d_informe_convalidacion;
        this.r_nota_director = r_nota_director;
        this.r_cedula_identidad = r_cedula_identidad;
        this.r_record_academico = r_record_academico;
        this.r_informe_convalidacion = r_informe_convalidacion;
        this.c_informe_convalidacion = c_informe_convalidacion;
        this.f_informe_convalidacion = f_informe_convalidacion;
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

    public String getD_nota_director() {
        return this.d_nota_director;
    }

    public void setD_nota_director(String d_nota_director) {
        this.d_nota_director = d_nota_director;
    }

    public String getD_cedula_identidad() {
        return this.d_cedula_identidad;
    }

    public void setD_cedula_identidad(String d_cedula_identidad) {
        this.d_cedula_identidad = d_cedula_identidad;
    }

    public String getD_record_academico() {
        return this.d_record_academico;
    }

    public void setD_record_academico(String d_record_academico) {
        this.d_record_academico = d_record_academico;
    }

    public String getD_informe_convalidacion() {
        return this.d_informe_convalidacion;
    }

    public void setD_informe_convalidacion(String d_informe_convalidacion) {
        this.d_informe_convalidacion = d_informe_convalidacion;
    }

    public String getR_nota_director() {
        return this.r_nota_director;
    }

    public void setR_nota_director(String r_nota_director) {
        this.r_nota_director = r_nota_director;
    }

    public String getR_cedula_identidad() {
        return this.r_cedula_identidad;
    }

    public void setR_cedula_identidad(String r_cedula_identidad) {
        this.r_cedula_identidad = r_cedula_identidad;
    }

    public String getR_record_academico() {
        return this.r_record_academico;
    }

    public void setR_record_academico(String r_record_academico) {
        this.r_record_academico = r_record_academico;
    }

    public String getR_informe_convalidacion() {
        return this.r_informe_convalidacion;
    }

    public void setR_informe_convalidacion(String r_informe_convalidacion) {
        this.r_informe_convalidacion = r_informe_convalidacion;
    }

    public String getC_informe_convalidacion() {
        return this.c_informe_convalidacion;
    }

    public void setC_informe_convalidacion(String c_informe_convalidacion) {
        this.c_informe_convalidacion = c_informe_convalidacion;
    }

    public String getF_informe_convalidacion() {
        return this.f_informe_convalidacion;
    }

    public void setF_informe_convalidacion(String f_informe_convalidacion) {
        this.f_informe_convalidacion = f_informe_convalidacion;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    

}