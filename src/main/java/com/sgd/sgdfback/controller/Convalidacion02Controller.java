package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgd.sgdfback.model.Convalidacion02;
import com.sgd.sgdfback.object.ListarCYRequest;
import com.sgd.sgdfback.service.Convalidacion02Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/convalidacion02")
public class Convalidacion02Controller {

    private final Convalidacion02Service convalidacionService;

    public Convalidacion02Controller(Convalidacion02Service convalidacion02Service){
        this.convalidacionService = convalidacion02Service;
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

    @PostMapping("/listar-carrera-year")
    public List<Convalidacion02> postMethodName(@RequestBody ListarCYRequest request) {
        return convalidacionService.obtenerConvalidacionCarreraYear(request.getCarrera(), request.getYear());
    }
    

    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<Convalidacion02> crearConvalidacion(@RequestBody Convalidacion02 convalidacion02) {
        return new ResponseEntity<>(convalidacionService.crearConvalidacion(convalidacion02), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Convalidacion02> obtenerConvalidacionPorId(@PathVariable Integer id) {
        Optional<Convalidacion02> convalidacion = convalidacionService.obtenerConvalidacionPorId(id);
        return convalidacion.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Convalidacion02> obtenerTodasLasConvalidaciones() {
        return convalidacionService.obtenerTodasLasConvalidaciones();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Convalidacion02> actualizarConvalidacion(@PathVariable Integer id, @RequestBody Convalidacion02 convalidacion02) {
        Convalidacion02 convalidacionActualizada = convalidacionService.actualizarConvalidacion(id, convalidacion02);
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
