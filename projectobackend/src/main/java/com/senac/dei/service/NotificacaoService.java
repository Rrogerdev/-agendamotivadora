package com.senac.dei.service;

import com.senac.dei.dto.request.NotificacaoDTORequest;
import com.senac.dei.dto.request.NotificacaoDTOUpdateRequest;
import com.senac.dei.dto.response.NotificacaoDTOResponse;
import com.senac.dei.dto.response.NotificacaoDTOUpdateResponse;
import com.senac.dei.entity.Notificacao;
import com.senac.dei.repository.NotificacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacaoService {
    private NotificacaoRepository notificacaoRepository;


    @Autowired
    private ModelMapper modelMapper;
    public NotificacaoService(NotificacaoRepository notificacaoRepository){
        this.notificacaoRepository = notificacaoRepository;
    }



    public List<Notificacao> listarNotificacoes(){
        return this.notificacaoRepository.findAll();
    }




    public NotificacaoDTOResponse criarNotificacao(NotificacaoDTORequest notificacaoDTORequest) {

        Notificacao notificacao =modelMapper.map(notificacaoDTORequest,Notificacao.class);
        Notificacao notificacaoSave = this.notificacaoRepository.save(notificacao);
        NotificacaoDTOResponse notificacaoDTOResponse = modelMapper.map(notificacaoSave, NotificacaoDTOResponse.class);
        return notificacaoDTOResponse;

    }

    public void apagarNotificacao(Integer notificacaoId) {
        notificacaoRepository.apagarLogicoNotificacao(notificacaoId);
    }



    public Notificacao listarPorNotificacaoId(Integer notificacaoId) {
        return this.notificacaoRepository.findById(notificacaoId).orElse(null);
    }

    public NotificacaoDTOResponse atualizarNotificacao(Integer notificacaoId, NotificacaoDTOUpdateRequest notificacaoDTO) {
        Notificacao notificacao = this.listarPorNotificacaoId(notificacaoId);
        if (notificacao != null) {
            Notificacao notificacaoUpdate = modelMapper.map(notificacaoDTO, Notificacao.class);
            Notificacao tempResponse = notificacaoRepository.save(notificacaoUpdate);
            return modelMapper.map(tempResponse, NotificacaoDTOResponse.class);
        }
        return null;
    }

    public NotificacaoDTOUpdateResponse atualizarStatus(Integer notificacaoId, NotificacaoDTOUpdateRequest notificacaoDTO) {
        return null;
    }

}