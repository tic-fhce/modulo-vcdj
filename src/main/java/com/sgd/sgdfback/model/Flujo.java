package com.sgd.sgdfback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flujo")
public class Flujo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String flujo;
    private String proceso;
    private String proceso_sig;
    private String formulario;
    private Integer tiempo;
    

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Rol role;

    @OneToMany(mappedBy = "flujo")
    private List<ProcesoCondicion> procesos_cond;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Flujo() {
    }

    public Flujo(Integer id, String flujo, String proceso, String proceso_sig, String formulario, Integer tiempo, Rol role, List<ProcesoCondicion> procesos_cond, Categoria categoria) {
        this.id = id;
        this.flujo = flujo;
        this.proceso = proceso;
        this.proceso_sig = proceso_sig;
        this.formulario = formulario;
        this.tiempo = tiempo;
        this.role = role;
        this.procesos_cond = procesos_cond;
        this.categoria = categoria;
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

    public String getProceso_sig() {
        return this.proceso_sig;
    }

    public void setProceso_sig(String proceso_sig) {
        this.proceso_sig = proceso_sig;
    }

    public String getFormulario() {
        return this.formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public Integer getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Rol getRole() {
        return this.role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

    public List<ProcesoCondicion> getProcesos_cond() {
        return this.procesos_cond;
    }

    public void setProcesos_cond(List<ProcesoCondicion> procesos_cond) {
        this.procesos_cond = procesos_cond;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
