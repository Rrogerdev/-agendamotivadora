package com.senac.dei.service;


import com.senac.dei.dto.request.MetaDTORequest;
import com.senac.dei.dto.request.MissaoDTORequest;
import com.senac.dei.dto.response.MetaDTOResponse;
import com.senac.dei.dto.response.MissaoDTOResponse;
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
        Meta metaSave = this.metaRepository.save(meta);


        MetaDTOResponse metaDTOResponse = modelMapper.map(metaSave, MetaDTOResponse.class);
        return metaDTOResponse;

    }

    public void apagarMeta(Integer metaId) {
        metaRepository.apagarLogicoMeta(metaId);
    }
}