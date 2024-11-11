package com.sgd.sgdfback.object;

public class AprobacionPerfilCrearRequest {
    private String nrotramite;
    private String cambio_resolucion;
    private String modalidad;
    private String titulo;
    private String tutor;


    public AprobacionPerfilCrearRequest() {
    }

    public AprobacionPerfilCrearRequest(String nrotramite, String cambio_resolucion, String modalidad, String titulo, String tutor) {
        this.nrotramite = nrotramite;
        this.cambio_resolucion = cambio_resolucion;
        this.modalidad = modalidad;
        this.titulo = titulo;
        this.tutor = tutor;
    }

    public String getNrotramite() {
        return this.nrotramite;
    }

    public void setNrotramite(String nrotramite) {
        this.nrotramite = nrotramite;
    }

    public String getCambio_resolucion() {
        return this.cambio_resolucion;
    }

    public void setCambio_resolucion(String cambio_resolucion) {
        this.cambio_resolucion = cambio_resolucion;
    }

    public String getModalidad() {
        return this.modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTutor() {
        return this.tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
    
}
