package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgd.sgdfback.model.AprobacionPerfil;
import com.sgd.sgdfback.service.AprobacionPerfilService;

@RestController
@RequestMapping("/api/aprobacionPerfil")
public class AprobacionPerfilController {

    private final AprobacionPerfilService aprobacionService;

    public AprobacionPerfilController(AprobacionPerfilService aprobacionPerfilService){
        this.aprobacionService = aprobacionPerfilService;
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        try {
            String columna = data.get("colum");
            String param = data.get("param");
            String nroTramite = data.get("nrotramite");

            aprobacionService.actualizarColumna(columna, param, nroTramite);
            return ResponseEntity.ok("Actualizado");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/obtener")
    public ResponseEntity<String> obtener(@RequestBody Map<String, String> data) {
        try {
            String nroTramite = data.get("nrotramite");
            String columna = data.get("columna");

            String valor = aprobacionService.obtenerColumna(nroTramite, columna);
            return ResponseEntity.ok(valor);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<AprobacionPerfil> crearAprobacionPerfil(@RequestBody AprobacionPerfil aprobacionPerfil) {
        return new ResponseEntity<>(aprobacionService.crearAprobacionPerfil(aprobacionPerfil), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AprobacionPerfil> obtenerAprobacionPerfilPorId(@PathVariable Integer id) {
        Optional<AprobacionPerfil> aprobacionPerfil = aprobacionService.obtenerAprobacionPerfilPorId(id);
        return aprobacionPerfil.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<AprobacionPerfil> obtenerTodosLosAprobacionPerfil() {
        return aprobacionService.obtenerTodosLosAprobacionPerfil();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AprobacionPerfil> actualizarAprobacionPerfil(@PathVariable Integer id, @RequestBody AprobacionPerfil aprobacionPerfil) {
        AprobacionPerfil perfilActualizado = aprobacionService.actualizarAprobacionPerfil(id, aprobacionPerfil);
        if (perfilActualizado != null) {
            return ResponseEntity.ok(perfilActualizado);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAprobacionPerfil(@PathVariable Integer id) {
        try {
            aprobacionService.eliminarAprobacionPerfil(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
