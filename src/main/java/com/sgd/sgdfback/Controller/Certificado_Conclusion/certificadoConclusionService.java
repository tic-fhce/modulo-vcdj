package com.sgd.sgdfback.Controller.Certificado_Conclusion;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class certificadoConclusionService {

    private final certificadoConclusionRepository certificadoR;

    public void actualizarColum(String columna, String param, String nroTramite) {
        certificadoR.updateColum(columna, param, nroTramite);
    }

    public String obtenerColum(String nroTramite, String columna) {
        return certificadoR.obtenerColumna(nroTramite, columna);
    }
}
