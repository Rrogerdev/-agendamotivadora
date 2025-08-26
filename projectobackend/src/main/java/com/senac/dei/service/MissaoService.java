package com.senac.dei.service;

import com.senac.dei.entity.Missao;
import com.senac.dei.repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository){
        this.missaoRepository = missaoRepository;
    }


    public List<Missao> listarMissoes(){
        return this.missaoRepository.findAll();
    }
}