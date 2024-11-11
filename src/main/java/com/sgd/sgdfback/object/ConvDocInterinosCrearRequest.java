package com.sgd.sgdfback.object;

public class ConvDocInterinosCrearRequest {
    private String nrotramite;
    private String tipo;


    public ConvDocInterinosCrearRequest() {
    }


    public ConvDocInterinosCrearRequest(String nrotramite, String tipo) {
        this.nrotramite = nrotramite;
        this.tipo = tipo;
    }

    public String getNrotramite() {
        return this.nrotramite;
    }

    public void setNrotramite(String nrotramite) {
        this.nrotramite = nrotramite;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   

}
