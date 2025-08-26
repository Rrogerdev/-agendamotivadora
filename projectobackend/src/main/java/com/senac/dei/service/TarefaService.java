package com.senac.dei.service;


import com.senac.dei.entity.Tarefa;
import com.senac.dei.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }


    public List<Tarefa> listarTarefas(){
        return this.tarefaRepository.findAll();
    }
}
