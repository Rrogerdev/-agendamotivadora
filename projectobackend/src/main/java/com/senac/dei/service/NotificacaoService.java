package com.senac.dei.service;

import com.senac.dei.entity.Notificacao;
import com.senac.dei.repository.NotificacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacaoService {
    private NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository){
        this.notificacaoRepository = notificacaoRepository;
    }



    public List<Notificacao> listarNotificacoes(){
        return this.notificacaoRepository.findAll();
    }
}