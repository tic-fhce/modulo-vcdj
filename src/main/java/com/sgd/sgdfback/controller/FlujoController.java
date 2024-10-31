package com.sgd.sgdfback.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgd.sgdfback.model.Flujo;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.object.FlujoHabilitadoRequest;
import com.sgd.sgdfback.object.FlujoProcedimientoRequest;
import com.sgd.sgdfback.service.FlujoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/flujo")
public class FlujoController {

    private final FlujoService flujoService;

    public FlujoController(FlujoService flujoService){
        this.flujoService = flujoService;
    }

    @GetMapping("/listP1")
    public List<Flujo> listarFlujosPorUsuarioYProceso(@AuthenticationPrincipal Usuario user) {
        return flujoService.listarFlujosPorRoleIdYProceso(user.getUsername(), "P1");
    }

    @GetMapping("/list")
    public List<Flujo> getList() {
        return flujoService.obtenerTodosLosFlujos();
    }

    @PutMapping("/actualizar-habilitado")
    public ResponseEntity<Void> actualizarHabilitado(@RequestBody FlujoHabilitadoRequest request) {
        flujoService.actualizarHabilitado(request.getId(), request.getHabilitado());
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/actualizar-procedimiento")
    public ResponseEntity<Void> actualizarProcedimiento(@RequestBody FlujoProcedimientoRequest request) {
        flujoService.actualizarProcedimiento(request.getId(), request.getFormulario(), request.getRol(), request.getTiempo());
        return ResponseEntity.ok().build();
    }
}
