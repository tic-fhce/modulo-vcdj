package com.sgd.sgdfback.object;

public class UsuarioDatosResponse {
    private String username;
    private String rol;
    private String unidad;
    private String cif;

    public UsuarioDatosResponse() {
    }

    public UsuarioDatosResponse(String username, String rol, String unidad, String cif) {
        this.username = username;
        this.rol = rol;
        this.unidad = unidad;
        this.cif = cif;
    }

    private UsuarioDatosResponse(builder builder) {
        this.username = builder.username;
        this.rol = builder.rol;
        this.unidad = builder.unidad;
        this.cif = builder.cif;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUnidad() {
        return this.unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getCif() {
        return this.cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public static class builder {
        private String username;
        private String rol;
        private String unidad;
        private String cif;

        public builder username(String username) {
            this.username = username;
            return this;
        }

        public builder rol(String rol) {
            this.rol = rol;
            return this;
        }

        public builder unidad(String unidad) {
            this.unidad = unidad;
            return this;
        }

        public builder cif(String cif) {
            this.cif = cif;
            return this;
        }

        public UsuarioDatosResponse build() {
            return new UsuarioDatosResponse(this);
        }
    }
}
