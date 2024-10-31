package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgd.sgdfback.model.CertificadoConclusion;
import com.sgd.sgdfback.object.ListarCYRequest;
import com.sgd.sgdfback.service.CertificadoConclusionService;

@RestController
@RequestMapping("/certificadoConclusion")
public class CertificadoConclusionController {

    private final CertificadoConclusionService certificadoService;

    public CertificadoConclusionController(CertificadoConclusionService certificadoConclusionService){
        this.certificadoService = certificadoConclusionService;
    }

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

    @PostMapping("/listar-carrera-year")
    public List<CertificadoConclusion> getListarCarreraYear(@RequestBody ListarCYRequest request) {
        return certificadoService.obtenerCertificadosCarreraYear(request.getCarrera(), request.getYear());
    }

    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<CertificadoConclusion> crearCertificadoConclusion(@RequestBody CertificadoConclusion certificadoConclusion) {
        return new ResponseEntity<>(certificadoService.crearCertificadoConclusion(certificadoConclusion), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificadoConclusion> obtenerCertificadoConclusionPorId(@PathVariable Integer id) {
        Optional<CertificadoConclusion> certificado = certificadoService.obtenerCertificadoConclusionPorId(id);
        return certificado.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<CertificadoConclusion> obtenerTodosLosCertificados() {
        return certificadoService.obtenerTodosLosCertificados();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CertificadoConclusion> actualizarCertificadoConclusion(@PathVariable Integer id, @RequestBody CertificadoConclusion certificadoConclusion) {
        CertificadoConclusion certificadoActualizado = certificadoService.actualizarCertificadoConclusion(id, certificadoConclusion);
        if (certificadoActualizado != null) {
            return ResponseEntity.ok(certificadoActualizado);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCertificadoConclusion(@PathVariable Integer id) {
        try {
            certificadoService.eliminarCertificadoConclusion(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
