package com.sgd.sgdfback.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.object.DocumentoRecuperarRequest;
import com.sgd.sgdfback.service.DocumentoService;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {

    private final DocumentoService documentS;

    public DocumentoController(DocumentoService documentoService){
        this.documentS = documentoService;
    }

    @PostMapping("/subir")
    public ResponseEntity<String> subirDocumento(
            @AuthenticationPrincipal Usuario user,
            @RequestParam("file") MultipartFile file,
            @RequestParam("nombre") String fileName,
            @RequestParam("nrotramite") String nroTramite,
            @RequestParam("flujo") String flujo,
            @RequestParam("tabla") String tabla) {

        try {
            documentS.procesarDocumento(user.getId(), file, fileName, nroTramite, flujo, tabla);
            return ResponseEntity.ok().body("Datos subidos correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cargar los datos");
        }
    }

    @PostMapping("/recuperar")
    public ResponseEntity<Resource> recuperarDocumento(@RequestBody DocumentoRecuperarRequest request) {
        try {
            return documentS.obtenerDocumento(request);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/actualizarObservacion")
    public ResponseEntity<String> evaluacionDocumentos(@RequestBody Map<String, String> data) {
        String columna = data.get("columna");
        String observacion = data.get("observacion");
        String nroTramite = data.get("nrotramite");
        String tabla = data.get("tabla");

        documentS.actualizarObservacion(columna, observacion, nroTramite, tabla);

        return ResponseEntity.ok("Actualizado");
    }

    @PostMapping("/observacionDocumento")
    public ResponseEntity<String> observacionDocumentos(@RequestBody Map<String, String> data) {
        String nroTramite = data.get("nrotramite");
        String columna = data.get("columna");
        String tabla = data.get("tabla");

        String observacion = documentS.obtenerObservacionDocumentos(nroTramite, columna, tabla);
        return ResponseEntity.ok(observacion);
    }
}
