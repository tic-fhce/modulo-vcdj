package com.sgd.sgdfback.object;

public class AprobacionPerfilCrearRequest {
    private String nrotramite;
    private String modalidad;
    private String titulo;
    private String tutor;


    public AprobacionPerfilCrearRequest() {
    }

    public AprobacionPerfilCrearRequest(String nrotramite, String modalidad, String titulo, String tutor) {
        this.nrotramite = nrotramite;
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
