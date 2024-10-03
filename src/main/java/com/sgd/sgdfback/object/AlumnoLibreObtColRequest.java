package com.sgd.sgdfback.object;

public class AlumnoLibreObtColRequest {
    private String nrotramite;
    private String columna;


    public AlumnoLibreObtColRequest() {
    }

    public AlumnoLibreObtColRequest(String nrotramite, String columna) {
        this.nrotramite = nrotramite;
        this.columna = columna;
    }

    public String getNrotramite() {
        return this.nrotramite;
    }

    public void setNrotramite(String nrotramite) {
        this.nrotramite = nrotramite;
    }

    public String getColumna() {
        return this.columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

}
