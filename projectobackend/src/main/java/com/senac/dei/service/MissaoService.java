package com.senac.dei.service;

import com.senac.dei.dto.request.MissaoDTORequest;
import com.senac.dei.dto.request.MissaoDTOUpdateRequest;
import com.senac.dei.dto.response.MissaoDTOResponse;
import com.senac.dei.dto.response.MissaoDTOUpdateResponse;
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
        missao.setStatus(1);
        Missao missaoSave = this.missaoRepository.save(missao);
        return modelMapper.map(missaoSave, MissaoDTOResponse.class);

    }


    public void apagarMissao(Integer missaoId) {
        missaoRepository.apagarLogicoMissao(missaoId);
    }

    public List<Missao> listarMissoesPorMeta(Integer metaId) {
        return this.missaoRepository.obterNotificacaoPorMetaId(metaId);

    }
    public Missao listarPorMissaoId(Integer missaoId) {
        return this.missaoRepository.findById(missaoId).orElse(null);
    }
    public MissaoDTOUpdateResponse atualizarStatus(Integer missaoId, MissaoDTOUpdateRequest missaoUpdateDTO) {

        Missao missao = this.listarPorMissaoId(missaoId);
        if (missao != null) {
            missao.setStatus(missaoUpdateDTO.getMissao_status());
            Missao tempResponse = missaoRepository.save(missao);
            return modelMapper.map(tempResponse, MissaoDTOUpdateResponse.class);
        }
        return null;
    }

    public MissaoDTOResponse atualizarMissao(Integer missaoId, MissaoDTORequest missaoDTO) {
        Missao missao = this.listarPorMissaoId(missaoId);
        if (missao != null) {
            missao.setMissao_inicio(missaoDTO.getMissao_inicio());
            missao.setMissao_prazo(missaoDTO.getMissao_prazo());
            missao.setMissao_titulo(missaoDTO.getMissao_titulo());



            Missao tempResponse = missaoRepository.save(missao);
            return modelMapper.map(tempResponse, MissaoDTOResponse.class);
        }
        return null;
    }
}