package com.senac.dei.controller;

import com.senac.dei.entity.Missao;
import com.senac.dei.service.MissaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




@RestController
@RequestMapping
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

}
