package com.senac.dei.service;


import com.senac.dei.dto.request.NotificacaoDTORequest;
import com.senac.dei.dto.request.TarefaDTORequest;
import com.senac.dei.dto.response.NotificacaoDTOResponse;
import com.senac.dei.dto.response.TarefaDTOResponse;
import com.senac.dei.entity.Meta;
import com.senac.dei.entity.Missao;
import com.senac.dei.entity.Notificacao;
import com.senac.dei.entity.Tarefa;
import com.senac.dei.repository.MissaoRepository;
import com.senac.dei.repository.TarefaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;
    private final MissaoRepository missaoRepository;

    public TarefaService(TarefaRepository tarefaRepository, MissaoRepository missaoRepository){
        this.tarefaRepository = tarefaRepository;
        this.missaoRepository = missaoRepository;
    }


    @Autowired
    private ModelMapper modelMapper;



    public List<Tarefa> listarTarefas(){
        return this.tarefaRepository.findAll();
    }




    public TarefaDTOResponse criarTarefa(TarefaDTORequest tarefaDTORequest) {

        Tarefa tarefa =modelMapper.map(tarefaDTORequest,Tarefa.class);
        tarefa.setStatus(1);
        Missao missao = missaoRepository.findById(tarefaDTORequest.getMissao_id())
                .orElseThrow(() -> new RuntimeException("Missão não encontrada"));
        tarefa.setMissao(missao);
        tarefa.setTarefa_id(0);
        Tarefa tarefaSave = this.tarefaRepository.save(tarefa);
        return modelMapper.map(tarefaSave, TarefaDTOResponse.class);
    }

    public void apagarTarefa(Integer tarefaId) {
        tarefaRepository.apagarLogicoTarefa(tarefaId);
    }
}
