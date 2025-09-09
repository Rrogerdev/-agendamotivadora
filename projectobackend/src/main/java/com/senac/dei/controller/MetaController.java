package com.senac.dei.controller;


import com.senac.dei.dto.request.MetaDTORequest;
import com.senac.dei.dto.request.MissaoDTORequest;
import com.senac.dei.dto.response.MetaDTOResponse;
import com.senac.dei.dto.response.MissaoDTOResponse;
import com.senac.dei.entity.Meta;
import com.senac.dei.service.MetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meta")
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



    @PostMapping("/criar")
    @Operation(summary = "Criar nova Meta", description = "Endpoint para criar uma nova Meta")
    public ResponseEntity<MetaDTOResponse> criarMeta(@Valid @RequestBody MetaDTORequest meta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(metaService.criarMeta(meta));
    }

    @DeleteMapping("/apagar/{metaId}")
    @Operation(summary = "Deletar meta por id", description = "Endpoint para deletar uma meta pelo id")
    public ResponseEntity<Void> apagarMeta(@PathVariable("metaId") Integer metaId) {
        metaService.apagarMeta(metaId);
        return ResponseEntity.noContent().build();
    }

}