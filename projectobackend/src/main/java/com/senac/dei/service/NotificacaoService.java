package com.senac.dei.service;

import com.senac.dei.dto.request.NotificacaoDTORequest;
import com.senac.dei.dto.response.NotificacaoDTOResponse;
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

}