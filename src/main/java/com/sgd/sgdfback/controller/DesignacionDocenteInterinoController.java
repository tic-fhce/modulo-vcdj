package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgd.sgdfback.model.DesignacionDocentesInterinos;
import com.sgd.sgdfback.service.DesignacionDocenteInterinoService;

@RestController
@RequestMapping("/api/designacionDocInterinos")
public class DesignacionDocenteInterinoController {

    private final DesignacionDocenteInterinoService designacionService;

    public DesignacionDocenteInterinoController(DesignacionDocenteInterinoService designacionDocenteInterinoService){
        this.designacionService = designacionDocenteInterinoService;
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        try {
            String columna = data.get("colum");
            String param = data.get("param");
            String nroTramite = data.get("nrotramite");

            designacionService.actualizarColumna(columna, param, nroTramite);
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

            String valor = designacionService.obtenerColumna(nroTramite, columna);
            return ResponseEntity.ok(valor);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<DesignacionDocentesInterinos> crearDesignacion(@RequestBody DesignacionDocentesInterinos designacionDocenteInterino) {
        return new ResponseEntity<>(designacionService.crearDesignacion(designacionDocenteInterino), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesignacionDocentesInterinos> obtenerDesignacionPorId(@PathVariable Integer id) {
        Optional<DesignacionDocentesInterinos> designacion = designacionService.obtenerDesignacionPorId(id);
        return designacion.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<DesignacionDocentesInterinos> obtenerTodasLasDesignaciones() {
        return designacionService.obtenerTodasLasDesignaciones();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesignacionDocentesInterinos> actualizarDesignacion(@PathVariable Integer id, @RequestBody DesignacionDocentesInterinos designacionDocenteInterino) {
        DesignacionDocentesInterinos designacionActualizada = designacionService.actualizarDesignacion(id, designacionDocenteInterino);
        if (designacionActualizada != null) {
            return ResponseEntity.ok(designacionActualizada);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDesignacion(@PathVariable Integer id) {
        try {
            designacionService.eliminarDesignacion(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
