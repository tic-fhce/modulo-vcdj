package com.sgd.sgdfback.Controller.Compressor;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping("/api/zip")
public class PDFCompressorZip {

    private static final String COMPRESSED_PDF_DIR = "compressed_pdfs/";
    private static final long SIX_MB_IN_BYTES = 6 * 1024 * 1024;

    @PostMapping("/compress")
    public ResponseEntity<String> compressPDF(@RequestParam("file") MultipartFile file) {
        try {
            // Verificar si el archivo es mayor de 6 MB
            if (file.getSize() <= SIX_MB_IN_BYTES) {
                return ResponseEntity.ok("El archivo es menor o igual a 6 MB, no se requiere compresión.");
            }

            // Crear el directorio si no existe
            File directory = new File(COMPRESSED_PDF_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Nombre del archivo comprimido
            String compressedFileName = COMPRESSED_PDF_DIR + "compressed_" + file.getOriginalFilename();
            File compressedFile = new File(compressedFileName);

            // Cargar el documento original
            PDDocument document = PDDocument.load(file.getInputStream());
            PDDocument compressedDocument = new PDDocument();

            PDFRenderer pdfRenderer = new PDFRenderer(document);

            for (int page = 0; page < document.getNumberOfPages(); page++) {
                PDPage originalPage = document.getPage(page);
                PDRectangle mediaBox = originalPage.getMediaBox();
                BufferedImage image = pdfRenderer.renderImageWithDPI(page, 72); // Ajustar DPI según sea necesario

                PDPage compressedPage = new PDPage(mediaBox);
                compressedDocument.addPage(compressedPage);

                PDImageXObject pdImage = JPEGFactory.createFromImage(compressedDocument, image, 0.5f); // Calidad JPEG

                try (PDPageContentStream contentStream = new PDPageContentStream(compressedDocument, compressedPage)) {
                    contentStream.drawImage(pdImage, 0, 0, mediaBox.getWidth(), mediaBox.getHeight());
                }
            }

            compressedDocument.save(compressedFile);
            compressedDocument.close();
            document.close();

            // Crear el archivo ZIP
            @SuppressWarnings("null")
            String zipFileName = COMPRESSED_PDF_DIR + "compressed_" + file.getOriginalFilename().replace(".pdf", ".zip");
            File zipFile = new File(zipFileName);

            try (FileOutputStream fos = new FileOutputStream(zipFile);
                 ZipOutputStream zipOut = new ZipOutputStream(fos);
                 FileInputStream fis = new FileInputStream(compressedFile)) {

                ZipEntry zipEntry = new ZipEntry(compressedFile.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
            }

            // Eliminar el archivo PDF comprimido después de crear el ZIP
            compressedFile.delete();

            return ResponseEntity.ok("PDF comprimido y guardado en formato ZIP en: " + zipFile.getAbsolutePath());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al comprimir el PDF: " + e.getMessage());
        }
    }
}

