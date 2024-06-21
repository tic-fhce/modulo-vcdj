package com.sgd.sgdfback.Controller.Certificado_Unico;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/certificadoUnico")
public class certificadoUnicoController {

    private final certificadoUnicoService convalidacionS;

    @PostMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        String columna = data.get("colum");
        String param = data.get("param");
        String nroTramite = data.get("nrotramite");

        convalidacionS.actualizarColum(columna, param, nroTramite);

        return ResponseEntity.ok("Actualizado");
    }

    @PostMapping("/obtener")
    public String obtener(@RequestBody Map<String, String> data) {
        String nroTramite = data.get("nrotramite");
        String columna = data.get("columna");

        return convalidacionS.obtenerColum(nroTramite, columna);
    }
}

