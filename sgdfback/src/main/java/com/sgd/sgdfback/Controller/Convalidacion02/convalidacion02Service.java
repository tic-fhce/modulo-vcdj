package com.sgd.sgdfback.Controller.Convalidacion02;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class convalidacion02Service {

    private final convalidacion02Repository convalidacionR;

    public void actualizarColum(String columna, String param, String nroTramite) {
        convalidacionR.updateColum(columna, param, nroTramite);
    }

    public String obtenerColum(String nroTramite, String columna) {
        return convalidacionR.obtenerColumna(nroTramite, columna);
    }
}
