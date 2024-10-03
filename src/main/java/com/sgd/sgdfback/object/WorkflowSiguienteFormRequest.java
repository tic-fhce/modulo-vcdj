package com.sgd.sgdfback.object;

public class WorkflowSiguienteFormRequest {
    private String flujo;
    private String proceso;
    private String tramiteId;
    private String condicion;
    private String comentario;


    public WorkflowSiguienteFormRequest() {
    }

    public WorkflowSiguienteFormRequest(String flujo, String proceso, String tramiteId, String condicion, String comentario) {
        this.flujo = flujo;
        this.proceso = proceso;
        this.tramiteId = tramiteId;
        this.condicion = condicion;
        this.comentario = comentario;
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

    public String getTramiteId() {
        return this.tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
    }

    public String getCondicion() {
        return this.condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
