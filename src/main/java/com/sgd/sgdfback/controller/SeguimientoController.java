package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.service.SeguimientoService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seguimiento")
public class SeguimientoController {

    private final SeguimientoService seguimientoService;
    private final ObjectMapper objectMapper;

    @GetMapping("/listar")
    public ResponseEntity<String> listar() {
        List<Map<String, Object>> list = seguimientoService.listarSeguimientos();
        return convertToJsonResponse(list);
    }

    @GetMapping("/tramitePendiente")
    public ResponseEntity<String> listarTramitesPendientes(@AuthenticationPrincipal Usuario user) {
        List<Map<String, Object>> pendientesList = seguimientoService.listarTramitesPendientes(user.getId());
        return convertToJsonResponse(pendientesList);
    }

    @GetMapping("/tramiteConcluido")
    public ResponseEntity<String> listarTramitesConcluidos(@AuthenticationPrincipal Usuario user) {
        List<Map<String, Object>> concluidosList = seguimientoService.listarTramitesConcluidos(user.getId());
        return convertToJsonResponse(concluidosList);
    }

    @GetMapping("/hojarutaAtendida")
    public ResponseEntity<String> listarhojasrutaAtendidas(@AuthenticationPrincipal Usuario user) {
        List<Map<String, Object>> hrAtendidas = seguimientoService.listarHR(user.getId());
        return convertToJsonResponse(hrAtendidas);
    }

    @GetMapping("/countTramitesPendientes")
    public Integer countTramPend(@AuthenticationPrincipal Usuario user) {
        return seguimientoService.countTramitesPend(user.getId());
    }

    @GetMapping("/countTramitesConcluidos")
    public Integer countTramConcl(@AuthenticationPrincipal Usuario user) {
        return seguimientoService.countTramitesConcl(user.getId());
    }
    

    @PostMapping("/visto")
    public ResponseEntity<String> visto(@RequestBody Map<String, String> data) {
        String flujo = data.get("flujo");
        String proceso = data.get("proceso");
        String nroTramite = data.get("nroTramite");

        seguimientoService.activateV(flujo, proceso, nroTramite);
        return ResponseEntity.ok("Actualizado");
    }

    private ResponseEntity<String> convertToJsonResponse(List<Map<String, Object>> list) {
        String jsonResult = null;
        try {
            jsonResult = objectMapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de errores
            return ResponseEntity.status(500).body("Error al convertir a JSON");
        }
        return ResponseEntity.ok(jsonResult);
    }
}
