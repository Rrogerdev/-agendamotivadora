package com.senac.dei.controller;


import com.senac.dei.dto.request.NotificacaoDTORequest;
import com.senac.dei.dto.request.TarefaDTORequest;
import com.senac.dei.dto.response.NotificacaoDTOResponse;
import com.senac.dei.dto.response.TarefaDTOResponse;
import com.senac.dei.entity.Tarefa;
import com.senac.dei.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tarefa")
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



    @PostMapping("/criar")
    @Operation(summary = "Criar nova Tarefa", description = "Endpoint para criar uma nova Tarefa")
    public ResponseEntity<TarefaDTOResponse> criarTarefa(@Valid @RequestBody TarefaDTORequest tarefa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criarTarefa(tarefa));
    }


    @DeleteMapping("/apagar/{tarefaId}")
    @Operation(summary = "Deletar tarefa por id", description = "Endpoint para deletar uma tarefa pelo id")
    public ResponseEntity<Void> apagarTarefa(@PathVariable("tarefaId") Integer tarefaId) {
        tarefaService.apagarTarefa(tarefaId);
        return ResponseEntity.noContent().build();
    }
}
