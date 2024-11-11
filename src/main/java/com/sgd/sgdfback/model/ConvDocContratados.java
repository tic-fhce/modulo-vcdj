package com.sgd.sgdfback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conv_doc_contratados")
public class ConvDocContratados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long cif;

    private String d_convocatoria;
    private String d_nota_atencion;
    private String d_certificacion_carga_horaria;

    private String r_convocatoria;
    private String r_certificacion_carga_horaria;

    private String c_convocatoria;
    private String c_nota_atencion;
    private String c_certificacion_carga_horaria;

    private String f_convocatoria;
    private String f_nota_atencion;
    private String f_certificacion_carga_horaria;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;

    public ConvDocContratados() {
    }

    public ConvDocContratados(Integer id, Long cif, String d_convocatoria, String d_nota_atencion, String d_certificacion_carga_horaria, String r_convocatoria, String r_certificacion_carga_horaria, String c_convocatoria, String c_nota_atencion, String c_certificacion_carga_horaria, String f_convocatoria, String f_nota_atencion, String f_certificacion_carga_horaria, Tramite tramite) {
        this.id = id;
        this.cif = cif;
        this.d_convocatoria = d_convocatoria;
        this.d_nota_atencion = d_nota_atencion;
        this.d_certificacion_carga_horaria = d_certificacion_carga_horaria;
        this.r_convocatoria = r_convocatoria;
        this.r_certificacion_carga_horaria = r_certificacion_carga_horaria;
        this.c_convocatoria = c_convocatoria;
        this.c_nota_atencion = c_nota_atencion;
        this.c_certificacion_carga_horaria = c_certificacion_carga_horaria;
        this.f_convocatoria = f_convocatoria;
        this.f_nota_atencion = f_nota_atencion;
        this.f_certificacion_carga_horaria = f_certificacion_carga_horaria;
        this.tramite = tramite;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCif() {
        return this.cif;
    }

    public void setCif(Long cif) {
        this.cif = cif;
    }

    public String getD_convocatoria() {
        return this.d_convocatoria;
    }

    public void setD_convocatoria(String d_convocatoria) {
        this.d_convocatoria = d_convocatoria;
    }

    public String getD_nota_atencion() {
        return this.d_nota_atencion;
    }

    public void setD_nota_atencion(String d_nota_atencion) {
        this.d_nota_atencion = d_nota_atencion;
    }

    public String getD_certificacion_carga_horaria() {
        return this.d_certificacion_carga_horaria;
    }

    public void setD_certificacion_carga_horaria(String d_certificacion_carga_horaria) {
        this.d_certificacion_carga_horaria = d_certificacion_carga_horaria;
    }

    public String getR_convocatoria() {
        return this.r_convocatoria;
    }

    public void setR_convocatoria(String r_convocatoria) {
        this.r_convocatoria = r_convocatoria;
    }

    public String getR_certificacion_carga_horaria() {
        return this.r_certificacion_carga_horaria;
    }

    public void setR_certificacion_carga_horaria(String r_certificacion_carga_horaria) {
        this.r_certificacion_carga_horaria = r_certificacion_carga_horaria;
    }

    public String getC_convocatoria() {
        return this.c_convocatoria;
    }

    public void setC_convocatoria(String c_convocatoria) {
        this.c_convocatoria = c_convocatoria;
    }

    public String getC_nota_atencion() {
        return this.c_nota_atencion;
    }

    public void setC_nota_atencion(String c_nota_atencion) {
        this.c_nota_atencion = c_nota_atencion;
    }

    public String getC_certificacion_carga_horaria() {
        return this.c_certificacion_carga_horaria;
    }

    public void setC_certificacion_carga_horaria(String c_certificacion_carga_horaria) {
        this.c_certificacion_carga_horaria = c_certificacion_carga_horaria;
    }

    public String getF_convocatoria() {
        return this.f_convocatoria;
    }

    public void setF_convocatoria(String f_convocatoria) {
        this.f_convocatoria = f_convocatoria;
    }

    public String getF_nota_atencion() {
        return this.f_nota_atencion;
    }

    public void setF_nota_atencion(String f_nota_atencion) {
        this.f_nota_atencion = f_nota_atencion;
    }

    public String getF_certificacion_carga_horaria() {
        return this.f_certificacion_carga_horaria;
    }

    public void setF_certificacion_carga_horaria(String f_certificacion_carga_horaria) {
        this.f_certificacion_carga_horaria = f_certificacion_carga_horaria;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }


}
