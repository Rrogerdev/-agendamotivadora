package com.senac.dei.service;


import com.senac.dei.entity.Meta;
import com.senac.dei.repository.MetaRepository;
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
}