package com.senac.dei.controller;

import com.senac.dei.entity.Missao;
import com.senac.dei.entity.Notificacao;
import com.senac.dei.service.MissaoService;
import com.senac.dei.service.NotificacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
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

}

