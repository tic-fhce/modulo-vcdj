package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgd.sgdfback.model.CertificadoUnico;
import com.sgd.sgdfback.service.CertificadoUnicoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/certificadoUnico")
public class CertificadoUnicoController {

    private final CertificadoUnicoService certificadoService;

    @PatchMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        try {
            String columna = data.get("colum");
            String param = data.get("param");
            String nroTramite = data.get("nrotramite");

            certificadoService.actualizarColumna(columna, param, nroTramite);
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

            String valor = certificadoService.obtenerColumna(nroTramite, columna);
            return ResponseEntity.ok(valor);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<CertificadoUnico> crearCertificadoUnico(@RequestBody CertificadoUnico certificadoUnico) {
        return new ResponseEntity<>(certificadoService.crearCertificadoUnico(certificadoUnico), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificadoUnico> obtenerCertificadoUnicoPorId(@PathVariable Integer id) {
        Optional<CertificadoUnico> certificadoUnico = certificadoService.obtenerCertificadoUnicoPorId(id);
        return certificadoUnico.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<CertificadoUnico> obtenerTodosLosCertificadosUnicos() {
        return certificadoService.obtenerTodosLosCertificadosUnicos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CertificadoUnico> actualizarCertificadoUnico(@PathVariable Integer id, @RequestBody CertificadoUnico certificadoUnico) {
        CertificadoUnico certificadoActualizado = certificadoService.actualizarCertificadoUnico(id, certificadoUnico);
        if (certificadoActualizado != null) {
            return ResponseEntity.ok(certificadoActualizado);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCertificadoUnico(@PathVariable Integer id) {
        try {
            certificadoService.eliminarCertificadoUnico(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
