package com.senac.dei.controller;

import com.senac.dei.dto.request.MissaoDTORequest;
import com.senac.dei.dto.response.MissaoDTOResponse;
import com.senac.dei.entity.Missao;
import com.senac.dei.service.MissaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/missao")
@Tag(name="Missao", description = "API para gerenciamento de missões")
public class MissaoController {


    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService){
        this.missaoService = missaoService;
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Missao>> listarMissoes(){
        return ResponseEntity.ok(missaoService.listarMissoes());
    }



    @PostMapping("/criar")
    @Operation(summary = "Criar nova Missao", description = "Endpoint para criar uma nova Missao")
    public ResponseEntity<MissaoDTOResponse> criarMissao(@Valid @RequestBody MissaoDTORequest missao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(missaoService.criarMissao(missao));
    }


    @DeleteMapping("/apagar/{missaoId}")
    @Operation(summary = "Deletar missao por id", description = "Endpoint para deletar uma missao pelo id")
    public ResponseEntity<Void> apagarMissao(@PathVariable("missaoId") Integer missaoId) {
        missaoService.apagarMissao(missaoId);
        return ResponseEntity.noContent().build();
    }
}
