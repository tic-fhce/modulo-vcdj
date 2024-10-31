package com.sgd.sgdfback.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "procesocond")
public class ProcesoCondicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String flujo;
    private String proceso;
    private String si;
    private String no;


    @OneToMany(mappedBy = "procesoCondicion")
    @JsonIgnore
    private List<Flujo> flujos;


    public ProcesoCondicion() {
    }


    public ProcesoCondicion(Integer id, String flujo, String proceso, String si, String no, List<Flujo> flujos) {
        this.id = id;
        this.flujo = flujo;
        this.proceso = proceso;
        this.si = si;
        this.no = no;
        this.flujos = flujos;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlujo() {
        return this.flujo;
    }

    public void setFlujo(String flujo) {
        this.flujo = flujo;
    }

    public String getProceso() {
        return this.proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getSi() {
        return this.si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public List<Flujo> getFlujos() {
        return this.flujos;
    }

    public void setFlujos(List<Flujo> flujos) {
        this.flujos = flujos;
    }
    
}
