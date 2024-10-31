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

import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.service.SeguimientoService;

@RestController
@RequestMapping("/seguimiento")
public class SeguimientoController {

    private final SeguimientoService seguimientoService;

    public SeguimientoController(SeguimientoService seguimientoService){
        this.seguimientoService = seguimientoService;
    }

    @GetMapping("/listar")
    public List<Map<String, Object>> listar() {
        return seguimientoService.listarSeguimientos();
    }

    @GetMapping("/tramitePendiente")
    public List<Map<String, Object>> listarTramitesPendientes(@AuthenticationPrincipal Usuario user) {
        return seguimientoService.listarTramitesPendientes(user);
    }

    @GetMapping("/tramiteConcluido")
    public List<Map<String, Object>> listarTramitesConcluidos(@AuthenticationPrincipal Usuario user) {
        return seguimientoService.listarTramitesConcluidos(user);
    }

    @GetMapping("/hojarutaAtendida")
    public List<Map<String, Object>> listarhojasrutaAtendidas(@AuthenticationPrincipal Usuario user) {
        return seguimientoService.listarHR(user);
    }

    @GetMapping("/countTramitesPendientes")
    public Integer countTramPend(@AuthenticationPrincipal Usuario user) {
        return seguimientoService.countTramitesPend(user);
    }

    @GetMapping("/countTramitesConcluidos")
    public Integer countTramConcl(@AuthenticationPrincipal Usuario user) {
        return seguimientoService.countTramitesConcl(user);
    }
    
    @PostMapping("/visto")
    public ResponseEntity<String> visto(@RequestBody Map<String, String> data) {
        Integer id = Integer.parseInt(data.get("id"));
        seguimientoService.activateV(id);
        return ResponseEntity.ok("Actualizado");
    }
}
