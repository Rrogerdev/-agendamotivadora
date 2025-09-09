package com.senac.dei.service;

import com.senac.dei.dto.request.TarefaDTORequest;
import com.senac.dei.dto.request.UsuarioDTORequest;
import com.senac.dei.dto.response.TarefaDTOResponse;
import com.senac.dei.dto.response.UsuarioDTOResponse;
import com.senac.dei.entity.Tarefa;
import com.senac.dei.entity.Usuario;
import com.senac.dei.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    private ModelMapper modelMapper;
    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }




    public UsuarioDTOResponse criarUsuario(UsuarioDTORequest UsuarioDTORequest) {
        System.out.println("Input Email: " + UsuarioDTORequest.getUsuario_email());
        Usuario usuario =modelMapper.map(UsuarioDTORequest,Usuario.class);
        Usuario usuarioSave = this.usuarioRepository.save(usuario);
        UsuarioDTOResponse usuarioDTOResponse = modelMapper.map(usuarioSave, UsuarioDTOResponse.class);
        return usuarioDTOResponse;

    }

    public void apagarUsuario(Integer usuarioId) {
        usuarioRepository.apagarLogicoUsuario(usuarioId);
    }
}