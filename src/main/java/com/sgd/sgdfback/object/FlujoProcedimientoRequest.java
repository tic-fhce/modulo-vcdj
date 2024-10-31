package com.sgd.sgdfback.object;

public class FlujoProcedimientoRequest {
    private Integer id;
    private String formulario;
    private Integer rol;
    private Integer tiempo;


    public FlujoProcedimientoRequest() {
    }

    public FlujoProcedimientoRequest(Integer id, String formulario, Integer rol, Integer tiempo) {
        this.id = id;
        this.formulario = formulario;
        this.rol = rol;
        this.tiempo = tiempo;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFormulario() {
        return this.formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public Integer getRol() {
        return this.rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public Integer getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

}
