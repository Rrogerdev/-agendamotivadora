package com.senac.dei.controller;

import com.senac.dei.dto.request.MissaoDTORequest;
import com.senac.dei.dto.request.MissaoDTOUpdateRequest;
import com.senac.dei.dto.request.NotificacaoDTORequest;
import com.senac.dei.dto.request.NotificacaoDTOUpdateRequest;
import com.senac.dei.dto.response.MissaoDTOResponse;
import com.senac.dei.dto.response.MissaoDTOUpdateResponse;
import com.senac.dei.dto.response.NotificacaoDTOResponse;
import com.senac.dei.dto.response.NotificacaoDTOUpdateResponse;
import com.senac.dei.entity.Missao;
import com.senac.dei.entity.Notificacao;
import com.senac.dei.service.MissaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/missao")
@Tag(name="Missao", description = "API para gerenciamento de missões")
public class MissaoController {


    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService){
        this.missaoService = missaoService;
    }

    @CrossOrigin(origins="*")
    @GetMapping("/listar")
    public ResponseEntity<List<Missao>> listarMissoes(){
        return ResponseEntity.ok(missaoService.listarMissoes());
    }

    @CrossOrigin(origins="*")
    @GetMapping("/listarPorMeta/{metaId}")
    public ResponseEntity<List<Missao>> listarMissoesPorUsuario(@PathVariable("metaId") Integer metaId){
        return ResponseEntity.ok(missaoService.listarMissoesPorMeta(metaId));
    }


    @CrossOrigin(origins="*")
    @PostMapping("/criar")
    @Operation(summary = "Criar nova Missao", description = "Endpoint para criar uma nova Missao")
    public ResponseEntity<MissaoDTOResponse> criarMissao(@Valid @RequestBody MissaoDTORequest missao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(missaoService.criarMissao(missao));
    }

    @CrossOrigin(origins="*")
    @DeleteMapping("/apagar/{missaoId}")
    @Operation(summary = "Deletar missao por id", description = "Endpoint para deletar uma missao pelo id")
    public ResponseEntity<Void> apagarMissao(@PathVariable("missaoId") Integer missaoId) {
        missaoService.apagarMissao(missaoId);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins="*")
    @PostMapping("/atualizar/{missaoId}")
    @Operation(summary = "Atualizar missao", description = "Endpoint para atualizar uma missao")
    public ResponseEntity<MissaoDTOResponse> atualizarMissao(@PathVariable("missaoId") Integer missaoId, @RequestBody MissaoDTORequest missaoDTO) {
        return ResponseEntity.ok(missaoService.atualizarMissao(missaoId, missaoDTO));
    }
    @CrossOrigin(origins="*")
    @PostMapping("/atualizarStatus/{missaoId}")
    @Operation(summary = "Atualizar missao", description = "Endpoint para atualizar uma missão")
    public ResponseEntity<MissaoDTOUpdateResponse> atualizarStatusMissao(@PathVariable("missaoId") Integer missaoId,
                                                                         @RequestBody MissaoDTOUpdateRequest missaoUpdateDTO) {
        return ResponseEntity.ok(missaoService.atualizarStatus(missaoId, missaoUpdateDTO));
    }

}
