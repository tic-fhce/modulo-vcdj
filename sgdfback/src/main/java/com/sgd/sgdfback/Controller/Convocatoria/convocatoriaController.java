package com.sgd.sgdfback.Controller.Convocatoria;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgd.sgdfback.Models.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/convocatoria")
public class convocatoriaController {

    private final convocatoriaService convocatoriaS;

    @PostMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data, @AuthenticationPrincipal User user) {
        String columna = data.get("colum");
        String param = data.get("param");
        String nroTramite = data.get("nrotramite");

        convocatoriaS.actualizarColum(columna, param, nroTramite, user.getId());

        return ResponseEntity.ok("Actualizado");
    }

    @PostMapping("/obtener")
    public String obtener(@RequestBody Map<String, String> data) {
        String nroTramite = data.get("nrotramite");
        String columna = data.get("columna");

        return convocatoriaS.obtenerColum(nroTramite, columna);
    }
}