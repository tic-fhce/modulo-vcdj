package com.sgd.sgdfback.object;

public class WorkflowInicioRequest {
    private String flujo;
    private String formulario;

    public WorkflowInicioRequest() {
    }

    public WorkflowInicioRequest(String flujo, String formulario) {
        this.flujo = flujo;
        this.formulario = formulario;
    }

    public String getFlujo() {
        return this.flujo;
    }

    public void setFlujo(String flujo) {
        this.flujo = flujo;
    }

    public String getFormulario() {
        return this.formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

}
