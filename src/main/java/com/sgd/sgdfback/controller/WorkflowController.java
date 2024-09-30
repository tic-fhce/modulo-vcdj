package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.object.workflow.InicioRequest;
import com.sgd.sgdfback.object.workflow.SiguienteFormRequest;
import com.sgd.sgdfback.service.WorkflowService;

import lombok.Data;

@Data
@RestController
@RequestMapping("/api/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;
    private final ObjectMapper objectMapper;

    @PostMapping("/inicioFlujo")
    public ResponseEntity<String> inicioFlujo(@AuthenticationPrincipal Usuario user,
            @RequestBody InicioRequest request) {
        List<Map<String, Object>> list = workflowService.inicioFlujo(user, request);
        return convertToJsonResponse(list);
    }

    @PostMapping("/siguienteFormulario")
    public ResponseEntity<String> siguienteFormulario(@AuthenticationPrincipal Usuario user,
            @RequestBody SiguienteFormRequest request) {
        String response = workflowService.siguienteFormulario(user, request);
        return ResponseEntity.ok(response);
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
