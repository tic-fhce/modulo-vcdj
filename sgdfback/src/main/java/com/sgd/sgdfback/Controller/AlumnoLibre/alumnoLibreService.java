package com.sgd.sgdfback.Controller.AlumnoLibre;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class alumnoLibreService {

    private final alumnoLibreRepository alumnoR;

    public void actualizarColum(String columna, String param, String nroTramite) {
        alumnoR.updateColum(columna, param, nroTramite);
    }

    public String obtenerColum(String nroTramite, String columna) {
        return alumnoR.obtenerColumna(nroTramite, columna);
    }
}
