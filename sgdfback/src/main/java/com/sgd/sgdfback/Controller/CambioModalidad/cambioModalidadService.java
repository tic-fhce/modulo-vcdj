package com.sgd.sgdfback.Controller.CambioModalidad;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class cambioModalidadService {

    private final cambioModalidadRepository cambioR;

    public void actualizarColum(String columna, String param, String nroTramite) {
        cambioR.updateColum(columna, param, nroTramite);
    }

    public String obtenerColum(String nroTramite, String columna) {
        return cambioR.obtenerColumna(nroTramite, columna);
    }

    public Map<String, Object> obtenerTodoPorTramiteId(String nroTramite) {
        return cambioR.obtenerTodoPorTramiteId(nroTramite);
    }
    
}
