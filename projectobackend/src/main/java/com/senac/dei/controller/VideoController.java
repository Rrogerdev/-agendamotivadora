package com.senac.dei.controller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    @GetMapping(value = "/video", produces = "video/mp4")
    public ResponseEntity<Resource> streamVideo() {
        Resource video = new ClassPathResource("static/video.mp4");

        if (video.exists() && video.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .header("Accept-Ranges", "bytes")
                    .body(video);
        } else {
            System.err.println("ERRO: Arquivo 'static/video.mp4' não encontrado no CLASSPATH.");
            return ResponseEntity.notFound().build();
        }
    }
}