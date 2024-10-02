package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgd.sgdfback.model.Convalidacion01;
import com.sgd.sgdfback.service.Convalidacion01Service;

@RestController
@RequestMapping("/api/convalidacion01")
public class Convalidacion01Controller {

    private final Convalidacion01Service convalidacionService;

    public Convalidacion01Controller(Convalidacion01Service convalidacion01Service){
        this.convalidacionService = convalidacion01Service;
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        try {
            String columna = data.get("colum");
            String param = data.get("param");
            String nroTramite = data.get("nrotramite");

            convalidacionService.actualizarColumna(columna, param, nroTramite);
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

            String valor = convalidacionService.obtenerColumna(nroTramite, columna);
            return ResponseEntity.ok(valor);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<Convalidacion01> crearConvalidacion(@RequestBody Convalidacion01 convalidacion01) {
        return new ResponseEntity<>(convalidacionService.crearConvalidacion(convalidacion01), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Convalidacion01> obtenerConvalidacionPorId(@PathVariable Integer id) {
        Optional<Convalidacion01> convalidacion = convalidacionService.obtenerConvalidacionPorId(id);
        return convalidacion.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Convalidacion01> obtenerTodasLasConvalidaciones() {
        return convalidacionService.obtenerTodasLasConvalidaciones();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Convalidacion01> actualizarConvalidacion(@PathVariable Integer id, @RequestBody Convalidacion01 convalidacion01) {
        Convalidacion01 convalidacionActualizada = convalidacionService.actualizarConvalidacion(id, convalidacion01);
        if (convalidacionActualizada != null) {
            return ResponseEntity.ok(convalidacionActualizada);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarConvalidacion(@PathVariable Integer id) {
        try {
            convalidacionService.eliminarConvalidacion(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
