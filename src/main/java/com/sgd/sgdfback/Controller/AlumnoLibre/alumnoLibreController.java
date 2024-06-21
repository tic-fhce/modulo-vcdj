package com.sgd.sgdfback.Controller.AlumnoLibre;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/alumnoLibre")
public class alumnoLibreController {

    private final alumnoLibreService alumnoS;

    @PostMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        String columna = data.get("colum");
        String param = data.get("param");
        String nroTramite = data.get("nrotramite");

        alumnoS.actualizarColum(columna, param, nroTramite);

        return ResponseEntity.ok("Actualizado");
    }

    @PostMapping("/obtener")
    public String obtener(@RequestBody Map<String, String> data) {
        String nroTramite = data.get("nrotramite");
        String columna = data.get("columna");

        return alumnoS.obtenerColum(nroTramite, columna);
    }
}

