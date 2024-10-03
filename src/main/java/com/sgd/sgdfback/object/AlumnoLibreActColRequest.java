package com.sgd.sgdfback.object;

public class AlumnoLibreActColRequest {
    private String colum;
    private String param;
    private String nrotramite;

    public AlumnoLibreActColRequest() {
    }

    public AlumnoLibreActColRequest(String colum, String param, String nrotramite) {
        this.colum = colum;
        this.param = param;
        this.nrotramite = nrotramite;
    }

    public String getColum() {
        return this.colum;
    }

    public void setColum(String colum) {
        this.colum = colum;
    }

    public String getParam() {
        return this.param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getNrotramite() {
        return this.nrotramite;
    }

    public void setNrotramite(String nrotramite) {
        this.nrotramite = nrotramite;
    }

}
