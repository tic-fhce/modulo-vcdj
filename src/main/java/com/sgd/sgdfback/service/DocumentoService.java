package com.sgd.sgdfback.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.sgd.sgdfback.object.DocumentoRecuperarRequest;

import java.io.IOException;

public interface DocumentoService {
    void procesarDocumento(Integer userId, MultipartFile file, String fileName, String nroTramite, String flujo, String tabla) throws IOException;
    ResponseEntity<Resource> obtenerDocumento(DocumentoRecuperarRequest request) throws IOException;
    void actualizarObservacion(String columna, String observacion, String nroTramite, String tabla);
    String obtenerObservacionDocumentos(String nroTramite, String columna, String tabla);
}
