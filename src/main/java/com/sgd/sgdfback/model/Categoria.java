package com.sgd.sgdfback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    private String id;
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Flujo> flujos;

    public Categoria() {
    }

    public Categoria(String id, String nombre, List<Flujo> flujos) {
        this.id = id;
        this.nombre = nombre;
        this.flujos = flujos;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Flujo> getFlujos() {
        return this.flujos;
    }

    public void setFlujos(List<Flujo> flujos) {
        this.flujos = flujos;
    }

}