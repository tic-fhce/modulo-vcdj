package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.service.TramiteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tramite")
public class TramiteController {

    private final TramiteService tramiteService;
    private final ObjectMapper objectMapper;

    @GetMapping("/listar")
    public ResponseEntity<String> listar() {
        List<Map<String, Object>> list = tramiteService.listarTramites();
        return convertToJsonResponse(list);
    }

    @PostMapping("listarSeguimientoTramite")
    public ResponseEntity<String> listarSeguimientoTramite(@AuthenticationPrincipal Usuario user) {
        List<Map<String, Object>> list = tramiteService.listarSeguimiento(user.getId());
        return convertToJsonResponse(list);
    }
    

    private ResponseEntity<String> convertToJsonResponse(List<Map<String, Object>> list) {
        String jsonResult = null;
        try {
            jsonResult = objectMapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al convertir a JSON");
        }
        return ResponseEntity.ok(jsonResult);
    }
}
