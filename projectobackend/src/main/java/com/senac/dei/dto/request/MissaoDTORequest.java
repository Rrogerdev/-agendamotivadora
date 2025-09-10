package com.senac.dei.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.dei.entity.Tarefa;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

public class MissaoDTORequest {




    private int missao_id;




    private String missao_titulo;




    private LocalDateTime missao_prazo;



    private int tarefa_id;

    private int missao_status;

    public int getMissao_status() {
        return missao_status;
    }

    public void setMissao_status(int missao_status) {
        this.missao_status = missao_status;
    }

    public int getMissao_id() {
        return missao_id;
    }

    public void setMissao_id(int missao_id) {
        this.missao_id = missao_id;
    }

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

    public int getTarefa_id() {
        return tarefa_id;
    }

    public void setTarefa_id(int tarefa_id) {
        this.tarefa_id = tarefa_id;
    }

    public int getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(int meta_id) {
        this.meta_id = meta_id;
    }

    private int meta_id;
}
