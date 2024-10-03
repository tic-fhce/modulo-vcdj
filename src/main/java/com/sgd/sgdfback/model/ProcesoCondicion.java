package com.sgd.sgdfback.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    @ManyToOne
    @JoinColumn(name = "flujo_id")
    private Flujo flujo2;


    public ProcesoCondicion() {
    }


    public ProcesoCondicion(Integer id, String flujo, String proceso, String si, String no, Flujo flujo2) {
        this.id = id;
        this.flujo = flujo;
        this.proceso = proceso;
        this.si = si;
        this.no = no;
        this.flujo2 = flujo2;
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

    public Flujo getFlujo2() {
        return this.flujo2;
    }

    public void setFlujo2(Flujo flujo2) {
        this.flujo2 = flujo2;
    }

}
