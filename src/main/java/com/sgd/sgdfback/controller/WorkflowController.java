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

import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.object.WorkflowSiguienteFormRequest;
import com.sgd.sgdfback.object.WorkflowInicioRequest;
import com.sgd.sgdfback.service.WorkflowService;

@RestController
@RequestMapping("/api/workflow")
public class WorkflowController {

    @Autowired
    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService){
        this.workflowService = workflowService;
    }

    @PostMapping("/inicioFlujo")
    public List<Map<String, Object>> inicioFlujo(@AuthenticationPrincipal Usuario usuario, @RequestBody WorkflowInicioRequest request) {
        return workflowService.inicioFlujo(usuario, request);
    }

    @PostMapping("/siguienteFormulario")
    public ResponseEntity<String> siguienteFormulario(@AuthenticationPrincipal Usuario user, @RequestBody WorkflowSiguienteFormRequest request) {
        String response = workflowService.siguienteFormulario(user, request);
        return ResponseEntity.ok(response);
    }
}
