package com.sgd.sgdfback.Controller.CambioModalidad;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cambioModalidad")
public class cambioModalidadController {

    private final cambioModalidadService cambioS;

    @PostMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        String columna = data.get("colum");
        String param = data.get("param");
        String nroTramite = data.get("nrotramite");

        cambioS.actualizarColum(columna, param, nroTramite);

        return ResponseEntity.ok("Actualizado");
    }

    @PostMapping("/obtener")
    public String obtener(@RequestBody Map<String, String> data) {
        String nroTramite = data.get("nrotramite");
        String columna = data.get("columna");

        return cambioS.obtenerColum(nroTramite, columna);
    }

    @PostMapping("/obtenerFila")
    public ResponseEntity<Map<String, Object>> obtenerTodo(@RequestBody Map<String, String> data) {
        String nroTramite = data.get("nrotramite");
        Map<String, Object> resultado = cambioS.obtenerTodoPorTramiteId(nroTramite);
        return ResponseEntity.ok(resultado);
    }

}
