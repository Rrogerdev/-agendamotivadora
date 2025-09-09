package com.senac.dei.service;

import com.senac.dei.dto.request.MissaoDTORequest;
import com.senac.dei.dto.request.NotificacaoDTORequest;
import com.senac.dei.dto.response.MissaoDTOResponse;
import com.senac.dei.dto.response.NotificacaoDTOResponse;
import com.senac.dei.entity.Missao;
import com.senac.dei.entity.Notificacao;
import com.senac.dei.repository.MissaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository){
        this.missaoRepository = missaoRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<Missao> listarMissoes(){
        return this.missaoRepository.findAll();
    }




    public MissaoDTOResponse criarMissao(MissaoDTORequest missaoDTORequest) {

        Missao missao =modelMapper.map(missaoDTORequest,Missao.class);
        Missao missaoSave = this.missaoRepository.save(missao);
        MissaoDTOResponse missaoDTOResponse = modelMapper.map(missaoSave, MissaoDTOResponse.class);
        return missaoDTOResponse;

    }


    public void apagarMissao(Integer missaoId) {
        missaoRepository.apagarLogicoMissao(missaoId);
    }
}