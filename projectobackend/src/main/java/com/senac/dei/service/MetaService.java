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
import com.senac.dei.repository.MetaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {
    private MetaRepository metaRepository;

    public MetaService(MetaRepository metaRepository){
        this.metaRepository = metaRepository;
    }


    public List<Meta> listarMetas(){
        return this.metaRepository.findAll();
    }


    @Autowired
    private ModelMapper modelMapper;


    public MetaDTOResponse criarMeta(MetaDTORequest metaDTORequest) {

        Meta meta =modelMapper.map(metaDTORequest, Meta.class);
        meta.setStatus(1);
        Meta metaSave = this.metaRepository.save(meta);


        MetaDTOResponse metaDTOResponse = modelMapper.map(metaSave, MetaDTOResponse.class);
        return metaDTOResponse;

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
        return this.metaRepository.obterMetasPorUsuario(usuarioId);
    }
}