package com.senac.dei.service;

import com.senac.dei.dto.request.NotificacaoDTORequest;
import com.senac.dei.dto.request.NotificacaoDTOUpdateRequest;
import com.senac.dei.dto.response.NotificacaoDTOResponse;
import com.senac.dei.dto.response.NotificacaoDTOUpdateResponse;
import com.senac.dei.entity.Notificacao;
import com.senac.dei.entity.Usuario;
import com.senac.dei.repository.NotificacaoRepository;
import com.senac.dei.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacaoService {
    private final NotificacaoRepository notificacaoRepository;
    private final UsuarioRepository usuarioRepository;


    @Autowired
    private ModelMapper modelMapper;
    public NotificacaoService(NotificacaoRepository notificacaoRepository, UsuarioRepository usuarioRepository){
        this.notificacaoRepository = notificacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }



    public List<Notificacao> listarNotificacoes(){
        return this.notificacaoRepository.findAll();
    }




    public NotificacaoDTOResponse criarNotificacao(NotificacaoDTORequest notificacaoDTORequest) {

        Notificacao notificacao =modelMapper.map(notificacaoDTORequest,Notificacao.class);
        notificacao.setStatus(1);
        Usuario usuario = usuarioRepository.findById(notificacaoDTORequest.getUsuario_id())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrada"));
        notificacao.setUsuario(usuario);
        notificacao.setNotificacao_id(0);
        Notificacao notificacaoSave = this.notificacaoRepository.save(notificacao);
        return modelMapper.map(notificacaoSave, NotificacaoDTOResponse.class);

    }

    public void apagarNotificacao(Integer notificacaoId) {
        notificacaoRepository.apagarLogicoNotificacao(notificacaoId);
    }



    public Notificacao listarPorNotificacaoId(Integer notificacaoId) {
        return this.notificacaoRepository.findById(notificacaoId).orElse(null);
    }


    public NotificacaoDTOResponse atualizarNotificacao(Integer notificacaoId, NotificacaoDTORequest notificacaoDTO) {
        Notificacao notificacao = this.listarPorNotificacaoId(notificacaoId);
        if (notificacao != null) {
            notificacao.setNotificacao_titulo(notificacaoDTO.getNotificacao_titulo());
            notificacao.setNotificacao_detalhe(notificacaoDTO.getNotificacao_detalhe());
            notificacao.setNotificacao_diaria(notificacaoDTO.getNotificacao_diaria());

            Notificacao tempResponse = notificacaoRepository.save(notificacao);
            return modelMapper.map(tempResponse, NotificacaoDTOResponse.class);
        }
        return null;
    }

    public NotificacaoDTOUpdateResponse atualizarStatus(Integer notificacaoId, NotificacaoDTOUpdateRequest notificacaoUpdateDTO) {
        Notificacao notificacao = this.listarPorNotificacaoId(notificacaoId);
        if (notificacao != null) {
            notificacao.setStatus(notificacaoUpdateDTO.getNotificacao_status());
            Notificacao tempResponse = notificacaoRepository.save(notificacao);
            return modelMapper.map(tempResponse, NotificacaoDTOUpdateResponse.class);
        }
        return null;
    }

    public List<Notificacao> listarNotificacoesPorUsuario(Integer usuarioId) {
        return this.notificacaoRepository.obterNotificacaoPorUsuarioId(usuarioId);
    }
}

