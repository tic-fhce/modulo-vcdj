package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgd.sgdfback.model.MateriaExtra;
import com.sgd.sgdfback.service.MateriaExtraService;

@RestController
@RequestMapping("/api/materiaExtra")
public class MateriaExtraController {

    private final MateriaExtraService materiaService;

    public MateriaExtraController(MateriaExtraService materiaExtraService){
        this.materiaService = materiaExtraService;
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        try {
            String columna = data.get("colum");
            String param = data.get("param");
            String nroTramite = data.get("nrotramite");

            materiaService.actualizarColumna(columna, param, nroTramite);
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

            String valor = materiaService.obtenerColumna(nroTramite, columna);
            return ResponseEntity.ok(valor);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<MateriaExtra> crearMateriaExtra(@RequestBody MateriaExtra materiaExtra) {
        return new ResponseEntity<>(materiaService.crearMateriaExtra(materiaExtra), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaExtra> obtenerMateriaExtraPorId(@PathVariable Integer id) {
        Optional<MateriaExtra> materia = materiaService.obtenerMateriaExtraPorId(id);
        return materia.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<MateriaExtra> obtenerTodasLasMateriasExtras() {
        return materiaService.obtenerTodasLasMateriasExtras();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaExtra> actualizarMateriaExtra(@PathVariable Integer id, @RequestBody MateriaExtra materiaExtra) {
        MateriaExtra materiaActualizada = materiaService.actualizarMateriaExtra(id, materiaExtra);
        if (materiaActualizada != null) {
            return ResponseEntity.ok(materiaActualizada);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMateriaExtra(@PathVariable Integer id) {
        try {
            materiaService.eliminarMateriaExtra(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
