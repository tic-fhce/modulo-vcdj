package com.sgd.sgdfback.Controller.AprobacionPerfil;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class aprobacionPerfilService {

    private final aprobacionPerfilRepositoty aprobacionR;

    public void actualizarColum(String columna, String param, String nroTramite) {
        aprobacionR.updateColum(columna, param, nroTramite);
    }

    public String obtenerColum(String nroTramite, String columna) {
        return aprobacionR.obtenerColumna(nroTramite, columna);
    }
}
