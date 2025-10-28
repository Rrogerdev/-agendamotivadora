package com.senac.dei.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.dei.entity.Tarefa;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

public class MissaoDTORequest {






    private String missao_titulo;




    private LocalDateTime missao_prazo;

    public LocalDateTime getMissao_inicio() {
        return missao_inicio;
    }

    public void setMissao_inicio(LocalDateTime missao_inicio) {
        this.missao_inicio = missao_inicio;
    }

    private LocalDateTime missao_inicio;


    public String getMissao_titulo() {
        return missao_titulo;
    }

    public void setMissao_titulo(String missao_titulo) {
        this.missao_titulo = missao_titulo;
    }

    public LocalDateTime getMissao_prazo() {
        return missao_prazo;
    }

    public void setMissao_prazo(LocalDateTime missao_prazo) {
        this.missao_prazo = missao_prazo;
    }

    public int getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(int meta_id) {
        this.meta_id = meta_id;
    }

    private int meta_id;
}
