package com.sgd.sgdfback.Controller.document;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    // ---------------DEVUELVE EN BYTES-------------------
    // @GetMapping("/generateQRCode")
    // public ResponseEntity<byte[]> generateQRCode(@RequestBody Map<String, String> data) {
    //     String text = data.get("text");
    //     Integer width = Integer.parseInt(data.get("width"));
    //     Integer height = Integer.parseInt(data.get("height"));
    //     try {
    //         byte[] image = qrCodeService.generateQRCodeImage(text, width, height);
    //         return ResponseEntity.status(HttpStatus.OK).body(image);
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    //     }
    // }


    @GetMapping(value = "/generateQRCode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode(@RequestBody Map<String, String> data) {
        String text = data.get("text");
        Integer width = Integer.parseInt(data.get("width"));
        Integer height = Integer.parseInt(data.get("height"));
        try {
            byte[] image = qrCodeService.generateQRCodeImage(text, width, height);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG).body(image);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

