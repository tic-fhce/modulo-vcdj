package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgd.sgdfback.model.AlumnoLibre;
import com.sgd.sgdfback.object.AlumnoLibreActColRequest;
import com.sgd.sgdfback.object.AlumnoLibreObtColRequest;
import com.sgd.sgdfback.service.AlumnoLibreService;
@RestController
@RequestMapping("/api/alumnoLibre")
public class AlumnoLibreController {
    
    private final AlumnoLibreService alumnoService;

    public AlumnoLibreController(AlumnoLibreService alumnoLibreService){
        this.alumnoService = alumnoLibreService;
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody AlumnoLibreActColRequest actualizarDTO) {
        try {
            alumnoService.actualizarColumna(actualizarDTO);
            return new ResponseEntity<>("Actualización exitosa", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/obtener")
    public ResponseEntity<String> obtener(@RequestBody AlumnoLibreObtColRequest obtenerDTO) {
        try {
            String valor = alumnoService.obtenerColumna(obtenerDTO);
            return ResponseEntity.ok(valor);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<AlumnoLibre> crearAlumno(@RequestBody AlumnoLibre alumnoLibre) {
        return new ResponseEntity<>(alumnoService.crearAlumno(alumnoLibre), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoLibre> obtenerAlumnoPorId(@PathVariable Integer id) {
        Optional<AlumnoLibre> alumno = alumnoService.obtenerAlumnoPorId(id);
        return alumno.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<AlumnoLibre> obtenerTodosLosAlumnos() {
        return alumnoService.obtenerTodosLosAlumnos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoLibre> actualizarAlumno(@PathVariable Integer id, @RequestBody AlumnoLibre alumnoLibre) {
        AlumnoLibre alumnoActualizado = alumnoService.actualizarAlumno(id, alumnoLibre);
        if (alumnoActualizado != null) {
            return ResponseEntity.ok(alumnoActualizado);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Integer id) {
        try {
            alumnoService.eliminarAlumno(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
