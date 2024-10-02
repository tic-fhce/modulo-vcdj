package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgd.sgdfback.model.ConcursoDocentesInterinos;
import com.sgd.sgdfback.service.ConcursoDocenteInterinoService;

@RestController
@RequestMapping("/api/concursoDocInterinos")
public class ConcursoDocenteInterinoController {

    private final ConcursoDocenteInterinoService concursoService;

    public ConcursoDocenteInterinoController(ConcursoDocenteInterinoService concursoDocenteInterinoService){
        this.concursoService = concursoDocenteInterinoService;
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        try {
            String columna = data.get("colum");
            String param = data.get("param");
            String nroTramite = data.get("nrotramite");

            concursoService.actualizarColumna(columna, param, nroTramite);
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

            String valor = concursoService.obtenerColumna(nroTramite, columna);
            return ResponseEntity.ok(valor);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<ConcursoDocentesInterinos> crearConcursoDocenteInterino(@RequestBody ConcursoDocentesInterinos concursoDocenteInterino) {
        return new ResponseEntity<>(concursoService.crearConcursoDocenteInterino(concursoDocenteInterino), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcursoDocentesInterinos> obtenerConcursoDocenteInterinoPorId(@PathVariable Integer id) {
        Optional<ConcursoDocentesInterinos> concursoDocenteInterino = concursoService.obtenerConcursoDocenteInterinoPorId(id);
        return concursoDocenteInterino.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<ConcursoDocentesInterinos> obtenerTodosLosConcursoDocentesInterinos() {
        return concursoService.obtenerTodosLosConcursoDocentesInterinos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConcursoDocentesInterinos> actualizarConcursoDocenteInterino(@PathVariable Integer id, @RequestBody ConcursoDocentesInterinos concursoDocenteInterino) {
        ConcursoDocentesInterinos concursoActualizado = concursoService.actualizarConcursoDocenteInterino(id, concursoDocenteInterino);
        if (concursoActualizado != null) {
            return ResponseEntity.ok(concursoActualizado);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarConcursoDocenteInterino(@PathVariable Integer id) {
        try {
            concursoService.eliminarConcursoDocenteInterino(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
