package com.sgd.sgdfback.Controller.Convocatoria;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class convocatoriaService {

    private final convocatoriaRepository convocatoriaR;

    public void actualizarColum(String columna, String param, String nroTramite, Integer userId) {
        convocatoriaR.updateColum(columna, param, nroTramite, userId);
    }

    public String obtenerColum(String nroTramite, String columna) {
        return convocatoriaR.obtenerColumna(nroTramite, columna);
    }
}
