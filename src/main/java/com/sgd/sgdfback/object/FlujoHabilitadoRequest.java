package com.sgd.sgdfback.object;

public class FlujoHabilitadoRequest {
    private Integer id;
    private String habilitado;


    public FlujoHabilitadoRequest(Integer id, String habilitado) {
        this.id = id;
        this.habilitado = habilitado;
    }

    public FlujoHabilitadoRequest() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHabilitado() {
        return this.habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

}
