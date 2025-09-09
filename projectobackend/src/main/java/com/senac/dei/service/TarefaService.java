package com.senac.dei.service;


import com.senac.dei.dto.request.NotificacaoDTORequest;
import com.senac.dei.dto.request.TarefaDTORequest;
import com.senac.dei.dto.response.NotificacaoDTOResponse;
import com.senac.dei.dto.response.TarefaDTOResponse;
import com.senac.dei.entity.Notificacao;
import com.senac.dei.entity.Tarefa;
import com.senac.dei.repository.TarefaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }


    @Autowired
    private ModelMapper modelMapper;

    public List<Tarefa> listarTarefas(){
        return this.tarefaRepository.findAll();
    }




    public TarefaDTOResponse criarTarefa(TarefaDTORequest TarefaDTORequest) {

        Tarefa tarefa =modelMapper.map(TarefaDTORequest,Tarefa.class);
        Tarefa tarefaSave = this.tarefaRepository.save(tarefa);
        TarefaDTOResponse tarefaDTOResponse = modelMapper.map(tarefaSave, TarefaDTOResponse.class);
        return tarefaDTOResponse;

    }

    public void apagarTarefa(Integer tarefaId) {
        tarefaRepository.apagarLogicoTarefa(tarefaId);
    }
}
