package com.sgd.sgdfback.Controller.Convalidacion01;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class convalidacion01Service {

    private final convalidacion01Repository convalidacionR;

    public void actualizarColum(String columna, String param, String nroTramite) {
        convalidacionR.updateColum(columna, param, nroTramite);
    }

    public String obtenerColum(String nroTramite, String columna) {
        return convalidacionR.obtenerColumna(nroTramite, columna);
    }
}

