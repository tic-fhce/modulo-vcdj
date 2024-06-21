package com.sgd.sgdfback.Controller._03_Workflow;

import org.springframework.web.bind.annotation.*;

import com.sgd.sgdfback.Models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.Map;

@RestController
@RequestMapping("/api/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @PostMapping("/inicioFlujo")
    public ResponseEntity<Map<String, String>> inicioFlujo(@AuthenticationPrincipal User user,
                                                           @RequestBody InicioRequest request) {
        Map<String, String> responseBody = workflowService.inicioFlujo(user, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PostMapping("/siguienteFormulario")
    public ResponseEntity<String> siguienteFormulario(@AuthenticationPrincipal User user,
                                                      @RequestBody SiguienteFormRequest request) {
        String response = workflowService.siguienteFormulario(user, request);
        return ResponseEntity.ok(response);
    }
}
