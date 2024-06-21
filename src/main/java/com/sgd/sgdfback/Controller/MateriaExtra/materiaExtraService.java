package com.sgd.sgdfback.Controller.MateriaExtra;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class materiaExtraService {

    private final materiaExtraRepository materiaR;

    public void actualizarColum(String columna, String param, String nroTramite) {
        materiaR.updateColum(columna, param, nroTramite);
    }

    public String obtenerColum(String nroTramite, String columna) {
        return materiaR.obtenerColumna(nroTramite, columna);
    }
}