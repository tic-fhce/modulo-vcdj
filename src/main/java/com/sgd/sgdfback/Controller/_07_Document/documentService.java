package com.sgd.sgdfback.Controller._07_Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class documentService {

    private final documentRepository documentR;

    public void procesarDocumento(Integer userId, MultipartFile file, String fileName, String nroTramite, String flujo, String tabla)
            throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("El archivo está vacío");
        }
        Integer count = documentR.countByTramiteId(nroTramite, tabla);
        String newFileName = guardarArchivo(file, nroTramite, fileName, flujo);
        if (count == 0) {
            documentR.insertConvalidacion(userId, fileName, newFileName, nroTramite, tabla);
        } else {
            documentR.updateConvalidacion(fileName, newFileName, nroTramite, tabla);
        }
    }

    public ResponseEntity<Resource> obtenerDocumento(RecuperarRequest request) throws IOException {
        String nroTramite = request.getNrotramite();
        String columna = request.getNombre();
        String nombreArchivo = documentR.obtenerNombreArchivo(nroTramite, columna, request.getTabla());
        String directorio = "./uploads/" + request.getFlujo() + "/tramite_" + nroTramite + "/";
        byte[] archivoBytes = Files.readAllBytes(Paths.get(directorio + nombreArchivo));
        ByteArrayResource resource = new ByteArrayResource(archivoBytes);

        // Inferir el tipo de contenido a partir de la extensión del archivo
        String contentType = Files.probeContentType(Paths.get(directorio + nombreArchivo));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + nombreArchivo + "\"")
                .body(resource);
    }

    public void actualizarObservacion(String columna, String observacion, String nroTramite, String tabla) {
        documentR.actualizarObservacionDoc(columna, observacion, nroTramite, tabla);
    }

    public String obtenerObservacionDocumentos(String nroTramite, String columna, String tabla) {
        return documentR.obtenerObservacionArchivo(nroTramite, columna, tabla);
    }

    public String guardarArchivo(MultipartFile file, String nroTramite, String fileName, String flujo) throws IOException {
        String originalFileName = file.getOriginalFilename();
        String extension = getFileExtension(originalFileName);
        String newFileName = fileName + "." + extension;

        String uploadDir = "./uploads/" + flujo + "/tramite_" + nroTramite; // Define la ubicación del archivo

        Path dirPath = Paths.get(uploadDir).toAbsolutePath().normalize(); // Crea el directorio si no existe
        Files.createDirectories(dirPath);

        Path filePath = dirPath.resolve(newFileName).normalize(); // Ruta del nuevo archivo

        // Verifica si el archivo ya existe en la ubicación
        if (Files.exists(filePath)) {
            // Si el archivo ya existe, lo reemplaza
            Files.delete(filePath);
        }

        // Guarda el nuevo archivo en la ubicación
        Files.copy(file.getInputStream(), filePath);

        return newFileName;
    }

    private String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}
