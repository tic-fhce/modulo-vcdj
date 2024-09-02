package com.sgd.sgdfback.Controller.DesignacionTribunal;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgd.sgdfback.Models.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/designacionTribunal")
public class designacionTribunalController {

    private final designacionTribunalService designacionS;
    private final ObjectMapper objectMapper;

    @PostMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        String columna = data.get("colum");
        String param = data.get("param");
        String nroTramite = data.get("nrotramite");

        designacionS.actualizarColum(columna, param, nroTramite);

        return ResponseEntity.ok("Actualizado");
    }

    @PostMapping("/obtener")
    public String obtener(@RequestBody Map<String, String> data) {
        String nroTramite = data.get("nrotramite");
        String columna = data.get("columna");

        return designacionS.obtenerColum(nroTramite, columna);
    }

    @PostMapping("/aprobacionPerfil")
    public String obtenerAprobacionPerfil(@AuthenticationPrincipal User user, @RequestBody(required = false) Map<String, String> data) {
        
        Integer authUserId = user.getId();
        System.out.println(authUserId);
        List<Map<String, Object>> perfil = designacionS.obtenerAprobacionPerfilPorUsuario(authUserId);

        // Si el resultado está vacío, intenta buscar por el userId proporcionado en el request
        if (perfil.isEmpty()) {
            Integer idPerfil = Integer.parseInt(data.get("idPerfil"));
            if(idPerfil != null){
                perfil = designacionS.obtenerAprobacionPerfilPorId(idPerfil);
            }
        };

        return convertToJsonResponse(perfil);
    }

    private String convertToJsonResponse(List<Map<String, Object>> list) {
        String jsonResult = null;
        try {
            jsonResult = objectMapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de errores
            jsonResult = "Error al convertir a JSON";
        }
        return jsonResult;
    }
    
}