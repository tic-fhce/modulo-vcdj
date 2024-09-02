package com.sgd.sgdfback.Controller.Designacion_Doc_Interinos;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DesignacionDocInterinosService {

    private final DesignacionDocInterinosRepository designacionR;

    public void actualizarColum(String columna, String param, String nroTramite) {
        designacionR.updateColum(columna, param, nroTramite);
    }

    public String obtenerColum(String nroTramite, String columna) {
        return designacionR.obtenerColumna(nroTramite, columna);
    }
}