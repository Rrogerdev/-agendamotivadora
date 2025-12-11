package com.senac.dei.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QrCodeController {

    @GetMapping(value = "/qr", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Resource> getQrCode() {
        Resource qrCode = new ClassPathResource("static/qr.png");

        if (qrCode.exists() && qrCode.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(qrCode);
        } else {
            System.err.println("ERRO: Arquivo 'static/qr.png' não encontrado no CLASSPATH.");
            return ResponseEntity.notFound().build();
        }
    }
}
