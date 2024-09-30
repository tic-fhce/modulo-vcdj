package com.sgd.sgdfback.service.impl;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sgd.sgdfback.dao.DocumentoDAO;
import com.sgd.sgdfback.object.document.RecuperarRequest;
import com.sgd.sgdfback.service.DocumentoService;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@AllArgsConstructor
@Service
public class DocumentoServiceImpl implements DocumentoService {

    private final DocumentoDAO documentRepository;

    @Override
    public void procesarDocumento(Integer userId, MultipartFile file, String fileName, String nroTramite, String flujo, String tabla)
            throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("El archivo está vacío");
        }

        Integer count = documentRepository.countByTramiteId(nroTramite, tabla);
        String newFileName = guardarArchivo(file, nroTramite, fileName, flujo);

        if (count == 0) {
            documentRepository.insertConvalidacion(userId, fileName, newFileName, nroTramite, tabla);
        } else {
            documentRepository.updateConvalidacion(fileName, newFileName, nroTramite, tabla);
        }
    }

    @Override
    public ResponseEntity<Resource> obtenerDocumento(RecuperarRequest request) throws IOException {
        String nombreArchivo = documentRepository.obtenerNombreArchivo(request.getNrotramite(), request.getNombre(), request.getTabla());
        Path path = Paths.get("./uploads/" + request.getFlujo() + "/tramite_" + request.getNrotramite() + "/" + nombreArchivo);
        
        if (!Files.exists(path)) {
            throw new IOException("El archivo no existe: " + path.toString());
        }

        byte[] archivoBytes = Files.readAllBytes(path);
        ByteArrayResource resource = new ByteArrayResource(archivoBytes);

        String contentType = "application/pdf";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + nombreArchivo + "\"")
                .body(resource);
    }

    @Override
    public void actualizarObservacion(String columna, String observacion, String nroTramite, String tabla) {
        documentRepository.actualizarObservacionDoc(columna, observacion, nroTramite, tabla);
    }

    @Override
    public String obtenerObservacionDocumentos(String nroTramite, String columna, String tabla) {
        return documentRepository.obtenerObservacionArchivo(nroTramite, columna, tabla);
    }

    private String guardarArchivo(MultipartFile file, String nroTramite, String fileName, String flujo) throws IOException {
        String originalFileName = file.getOriginalFilename();
        @SuppressWarnings("null")
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String newFileName = fileName + "." + extension;

        String uploadDir = "./uploads/" + flujo + "/tramite_" + nroTramite;
        Path dirPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(dirPath);

        Path filePath = dirPath.resolve(newFileName).normalize();
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        }

        Files.copy(file.getInputStream(), filePath);
        return newFileName;
    }
}
