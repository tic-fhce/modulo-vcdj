package com.sgd.sgdfback.object;

public class DocumentoRecuperarRequest {
    private String nombre;
    private String nrotramite;
    private String tabla;
    private String flujo;


    public DocumentoRecuperarRequest() {
    }

    public DocumentoRecuperarRequest(String nombre, String nrotramite, String tabla, String flujo) {
        this.nombre = nombre;
        this.nrotramite = nrotramite;
        this.tabla = tabla;
        this.flujo = flujo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNrotramite() {
        return this.nrotramite;
    }

    public void setNrotramite(String nrotramite) {
        this.nrotramite = nrotramite;
    }

    public String getTabla() {
        return this.tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getFlujo() {
        return this.flujo;
    }

    public void setFlujo(String flujo) {
        this.flujo = flujo;
    }

}
