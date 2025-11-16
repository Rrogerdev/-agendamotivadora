package com.senac.dei.service;


import com.senac.dei.dto.request.MetaDTORequest;
import com.senac.dei.dto.request.MetaDTOUpdateRequest;
import com.senac.dei.dto.request.MissaoDTORequest;
import com.senac.dei.dto.response.MetaDTOResponse;
import com.senac.dei.dto.response.MetaDTOUpdateResponse;
import com.senac.dei.dto.response.MissaoDTOResponse;
import com.senac.dei.dto.response.MissaoDTOUpdateResponse;
import com.senac.dei.entity.Meta;
import com.senac.dei.entity.Missao;
import com.senac.dei.entity.Usuario;
import com.senac.dei.repository.MetaRepository;
import com.senac.dei.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MetaService {
    private final MetaRepository metaRepository;
    private final UsuarioRepository usuarioRepository;

    public MetaService(MetaRepository metaRepository, UsuarioRepository usuarioRepository){
        this.metaRepository = metaRepository;
        this.usuarioRepository = usuarioRepository;
    }


    public List<Meta> listarMetas(){
        return this.metaRepository.findAll();
    }


    @Autowired
    private ModelMapper modelMapper;


    public MetaDTOResponse criarMeta(MetaDTORequest metaDTORequest) {
        Meta meta = modelMapper.map(metaDTORequest, Meta.class);
        meta.setStatus(1);
        Usuario usuario = usuarioRepository.findById(metaDTORequest.getUsuario_id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        meta.setUsuario(usuario);
        meta.setMeta_id(0);
        Meta metaSave = metaRepository.save(meta);
        return modelMapper.map(metaSave, MetaDTOResponse.class);
    }




    public void apagarMeta(Integer metaId) {
        metaRepository.apagarLogicoMeta(metaId);
    }



    public Meta listarPorMetaId(Integer metaId) {
        return this.metaRepository.findById(metaId).orElse(null);
    }
    public MetaDTOUpdateResponse atualizarStatus(Integer metaId, MetaDTOUpdateRequest metaUpdateDTO) {

        Meta meta = this.listarPorMetaId(metaId);
        if (meta != null) {
            meta.setStatus(metaUpdateDTO.getMeta_status());
            Meta tempResponse = metaRepository.save(meta);
            return modelMapper.map(tempResponse, MetaDTOUpdateResponse.class);
        }
        return null;
    }

    public MetaDTOResponse atualizarMeta(Integer metaId, MetaDTORequest metaDTO) {
        Meta meta = this.listarPorMetaId(metaId);
        if (meta!= null) {
            meta.setMeta_detalhe(metaDTO.getMeta_detalhe());
            meta.setMeta_inicio(metaDTO.getMeta_inicio());
            meta.setMeta_titulo(metaDTO.getMeta_titulo());
            meta.setMeta_prazo(metaDTO.getMeta_prazo());



            Meta tempResponse = metaRepository.save(meta);
            return modelMapper.map(tempResponse, MetaDTOResponse.class);
        }
        return null;

    }

    public List<Meta> listarMetasPorUsuario(Integer usuarioId) {
        List<Meta> metas = this.metaRepository.obterMetasPorUsuario(usuarioId);



        for (Meta meta : metas) {


            Set<Missao> missoesFiltradas = meta.getMissoes().stream()
                    .filter(missao -> missao.getStatus() != -1)
                    .collect(Collectors.toSet());

            meta.setMissoes(missoesFiltradas);
        }
        return metas;
    }
}