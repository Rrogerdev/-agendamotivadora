package com.senac.dei.controller;

import com.senac.dei.dto.request.NotificacaoDTORequest;
import com.senac.dei.dto.request.NotificacaoDTOUpdateRequest;
import com.senac.dei.dto.response.NotificacaoDTOResponse;
import com.senac.dei.dto.response.NotificacaoDTOUpdateResponse;
import com.senac.dei.entity.Notificacao;
import com.senac.dei.service.NotificacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/notificacao")
@Tag(name="Notificacao", description = "API para gerenciamento de notificacoes")
public class NotificacaoController {


    private NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService){
        this.notificacaoService = notificacaoService;
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Notificacao>> listarNotificacoes(){
        return ResponseEntity.ok(notificacaoService.listarNotificacoes());
    }

    @GetMapping("/listarPorUsuario/{usuarioId}")
    public ResponseEntity<List<Notificacao>> listarNotificacoesPorUsuario(@PathVariable("usuarioId") Integer usuarioId){
        return ResponseEntity.ok(notificacaoService.listarNotificacoesPorUsuario(usuarioId));
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar nova notificação", description = "Endpoint para criar uma nova notificação")
    public ResponseEntity<NotificacaoDTOResponse> criarParticipante(@Valid @RequestBody NotificacaoDTORequest notificacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificacaoService.criarNotificacao(notificacao));
    }

    @DeleteMapping("/apagar/{notificacaoId}")
    @Operation(summary = "Deletar notificacao por id", description = "Endpoint para deletar uma notificacao pelo id")
    public ResponseEntity<Void> apagarNotificacao(@PathVariable("notificacaoId") Integer notificacaoId) {
        notificacaoService.apagarNotificacao(notificacaoId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/atualizar/{notificacaoId}")
    @Operation(summary = "Atualizar notificacao", description = "Endpoint para atualizar uma notificacao")
    public ResponseEntity<NotificacaoDTOResponse> atualizarNotificacao(@PathVariable("notificacaoId") Integer notificacaoId, @RequestBody NotificacaoDTORequest notificacaoDTO) {
        return ResponseEntity.ok(notificacaoService.atualizarNotificacao(notificacaoId, notificacaoDTO));
    }
    @PostMapping("/atualizarStatus/{notificacaoId}")
    @Operation(summary = "Atualizar notificacao", description = "Endpoint para atualizar uma notificacao")
    public ResponseEntity<NotificacaoDTOUpdateResponse> atualizarStatusNotificacao(@PathVariable("notificacaoId") Integer notificacaoId,
       @RequestBody NotificacaoDTOUpdateRequest notificacaoUpdateDTO) {
        return ResponseEntity.ok(notificacaoService.atualizarStatus(notificacaoId, notificacaoUpdateDTO));
    }


}

