package com.sgd.sgdfback.Controller.DesignacionTribunal;

import java.util.*;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class designacionTribunalService {

    private final designacionTribunalRepositoty designacionR;

    public void actualizarColum(String columna, String param, String nroTramite) {
        designacionR.updateColum(columna, param, nroTramite);
    }

    public String obtenerColum(String nroTramite, String columna) {
        return designacionR.obtenerColumna(nroTramite, columna);
    }

    public List<Map<String, Object>> obtenerAprobacionPerfilPorUsuario(Integer userId) {
        return designacionR.obtenerAprobacionPerfil(userId);
    }

    public List<Map<String, Object>> obtenerAprobacionPerfilPorId(Integer perfilId) {
        return designacionR.obtenerAprobacionPerfilId(perfilId);
    }
}