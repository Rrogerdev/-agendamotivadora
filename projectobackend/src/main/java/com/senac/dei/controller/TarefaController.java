package com.senac.dei.controller;


import com.senac.dei.entity.Tarefa;
import com.senac.dei.service.TarefaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@Tag(name="Tarefa", description = "API para gerenciamento de tarefas")
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Tarefa>>listarTarefas(){
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }


}
