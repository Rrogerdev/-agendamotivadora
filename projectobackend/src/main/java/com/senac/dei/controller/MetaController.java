package com.senac.dei.controller;


import com.senac.dei.entity.Meta;
import com.senac.dei.service.MetaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@Tag(name="Meta", description = "API para gerenciamento de metas")
public class MetaController {


    private MetaService metaService;

    public MetaController(MetaService missaoService){
        this.metaService = metaService;
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Meta>> listarMetas(){
        return ResponseEntity.ok(metaService.listarMetas());
    }

}