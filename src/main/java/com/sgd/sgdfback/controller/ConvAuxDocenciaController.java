package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgd.sgdfback.model.ConvAuxDocencia;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.object.ConvDocInterinosCrearRequest;
import com.sgd.sgdfback.service.ConvAuxDocenciaService;

@RestController
@RequestMapping("/conv-aux-docencia")
public class ConvAuxDocenciaController {

    private final ConvAuxDocenciaService convocatoriaService;

    public ConvAuxDocenciaController(ConvAuxDocenciaService convocatoriaService) {
        this.convocatoriaService = convocatoriaService;
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data,
            @AuthenticationPrincipal Usuario user) {
        try {
            String columna = data.get("colum");
            String param = data.get("param");
            String nroTramite = data.get("nrotramite");

            convocatoriaService.actualizarColumna(columna, param, nroTramite, user.getId());
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

            String valor = convocatoriaService.obtenerColumna(nroTramite, columna);
            return ResponseEntity.ok(valor);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<ConvAuxDocencia> crearConvocatoria(@RequestBody ConvDocInterinosCrearRequest request) {
        return new ResponseEntity<>(convocatoriaService.crearConvocatoria(request), HttpStatus.CREATED);
    }

    @PostMapping("/obtenerC")
    public ResponseEntity<ConvAuxDocencia> obtenerConvocatoriaTramite(@RequestBody Map<String, String> data) {
        String nroTramite = data.get("nrotramite");
        try {
            Optional<ConvAuxDocencia> cd = convocatoriaService.obtenerConvocatoriaPorTramite(nroTramite);
            return cd.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.OK).body(null));
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error inesperado al obtener la conv_doc_contratados.", e);
        }
    }

    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<ConvAuxDocencia> crearConvocatoria(@RequestBody ConvAuxDocencia convocatoria) {
        return new ResponseEntity<>(convocatoriaService.crearConvocatoria(convocatoria), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConvAuxDocencia> obtenerConvocatoriaPorId(@PathVariable Integer id) {
        Optional<ConvAuxDocencia> convocatoria = convocatoriaService.obtenerConvocatoriaPorId(id);
        return convocatoria.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<ConvAuxDocencia> obtenerTodasLasConvocatorias() {
        return convocatoriaService.obtenerTodasLasConvocatorias();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConvAuxDocencia> actualizarConvocatoria(@PathVariable Integer id,
            @RequestBody ConvAuxDocencia convocatoria) {
        ConvAuxDocencia convocatoriaActualizada = convocatoriaService.actualizarConvocatoria(id, convocatoria);
        if (convocatoriaActualizada != null) {
            return ResponseEntity.ok(convocatoriaActualizada);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarConvocatoria(@PathVariable Integer id) {
        try {
            convocatoriaService.eliminarConvocatoria(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
