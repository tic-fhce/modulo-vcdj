package com.sgd.sgdfback.Controller.Compressor;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/mod")
public class PDFModifierController {

    private static final String MODIFIED_PDF_DIR = "modified_pdfs/";

    @PostMapping("/modify")
    public ResponseEntity<String> modifyPDF(@RequestParam("file") MultipartFile file,
                                            @RequestParam("signature") MultipartFile signature) {
        try {
            // Crear el directorio si no existe
            File directory = new File(MODIFIED_PDF_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Nombre del archivo modificado
            String modifiedFileName = MODIFIED_PDF_DIR + "modified_" + file.getOriginalFilename();
            File modifiedFile = new File(modifiedFileName);

            // Cargar el documento original
            PDDocument document = PDDocument.load(file.getInputStream());

            // Crear un archivo temporal para la imagen de la firma
            File tempSignatureFile = File.createTempFile("signature", ".png");
            try (FileOutputStream fos = new FileOutputStream(tempSignatureFile)) {
                fos.write(signature.getBytes());
            }

            // Cargar la imagen de la firma desde el archivo temporal
            PDImageXObject pdImage = PDImageXObject.createFromFileByContent(tempSignatureFile, document);

            // Buscar la palabra "[firma]" y obtener su posición
            for (int pageIndex = 0; pageIndex < document.getNumberOfPages(); pageIndex++) {
                PDPage page = document.getPage(pageIndex);
                PDFTextStripper stripper = new PDFTextStripper() {
                    @Override
                    protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
                        if (string.contains("[firma]")) {
                            for (TextPosition text : textPositions) {
                                if (text.getUnicode().equals("[") || text.getUnicode().equals("f")) {
                                    float x = text.getX();
                                    float y = text.getY();
                                    System.out.println(x + "  "+y);
                                    // float width = pdImage.getWidth();
                                    // float height = pdImage.getHeight();

                                    float width = 100;
                                    float height = 100;

                                    // Insertar la imagen en la posición de la palabra "[firma]"
                                    try (PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true)) {
                                        contentStream.drawImage(pdImage, x, y - height, width, height);
                                    }
                                    return; // Salir después de encontrar la primera ocurrencia
                                }
                            }
                        }
                        super.writeString(string, textPositions);
                    }
                };
                stripper.setStartPage(pageIndex + 1);
                stripper.setEndPage(pageIndex + 1);
                stripper.getText(document);
            }

            document.save(modifiedFile);
            document.close();

            // Eliminar el archivo temporal de la firma
            tempSignatureFile.delete();

            return ResponseEntity.ok("PDF modificado y guardado en: " + modifiedFile.getAbsolutePath());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar el PDF: " + e.getMessage());
        }
    }

    @GetMapping("/view/{fileName}")
    public ResponseEntity<InputStreamResource> viewPDF(@PathVariable String fileName) {
        try {
            File file = new File(MODIFIED_PDF_DIR + fileName);
            if (!file.exists() || !file.isFile()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamResource resource = new InputStreamResource(fileInputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");
            headers.setContentType(MediaType.APPLICATION_PDF);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
