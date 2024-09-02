package com.sgd.sgdfback.Controller._06_Flujo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgd.sgdfback.Models.User;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flujo")
public class FlujoController {

    private final FlujoService flujoService;
    private final ObjectMapper objectMapper;

    @GetMapping
    public String listarFlujosP1(@AuthenticationPrincipal User user) {
        List<Map<String, Object>> flujoList = flujoService.listarFlujosPorUsuarioYProceso(user.getUsername(), "P1");
        return convertToJsonResponse(flujoList);
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