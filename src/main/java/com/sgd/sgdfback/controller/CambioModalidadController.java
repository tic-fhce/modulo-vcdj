package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgd.sgdfback.model.CambioModalidad;
import com.sgd.sgdfback.service.CambioModalidadService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cambioModalidad")
public class CambioModalidadController {

    private final CambioModalidadService cambioService;

    @PatchMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        try {
            String columna = data.get("colum");
            String param = data.get("param");
            String nroTramite = data.get("nrotramite");

            cambioService.actualizarColumna(columna, param, nroTramite);
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

            String valor = cambioService.obtenerColumna(nroTramite, columna);
            return ResponseEntity.ok(valor);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/obtenerFila")
    public ResponseEntity<Map<String, Object>> obtenerTodo(@RequestBody Map<String, String> data) {
        try {
            String nroTramite = data.get("nrotramite");
            Map<String, Object> resultado = cambioService.obtenerTodoPorTramiteId(nroTramite);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<CambioModalidad> crearCambioModalidad(@RequestBody CambioModalidad cambioModalidad) {
        return new ResponseEntity<>(cambioService.crearCambioModalidad(cambioModalidad), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CambioModalidad> obtenerCambioModalidadPorId(@PathVariable Integer id) {
        Optional<CambioModalidad> cambioModalidad = cambioService.obtenerCambioModalidadPorId(id);
        return cambioModalidad.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<CambioModalidad> obtenerTodosLosCambioModalidad() {
        return cambioService.obtenerTodosLosCambioModalidad();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CambioModalidad> actualizarCambioModalidad(@PathVariable Integer id, @RequestBody CambioModalidad cambioModalidad) {
        CambioModalidad cambioActualizado = cambioService.actualizarCambioModalidad(id, cambioModalidad);
        if (cambioActualizado != null) {
            return ResponseEntity.ok(cambioActualizado);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCambioModalidad(@PathVariable Integer id) {
        try {
            cambioService.eliminarCambioModalidad(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
