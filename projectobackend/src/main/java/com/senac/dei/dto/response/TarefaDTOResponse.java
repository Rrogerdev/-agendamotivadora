package com.senac.dei.dto.response;

import java.time.LocalDateTime;

public class TarefaDTOResponse {





    private int tarefa_id;


    private int missao_id;


    private String tarefa_titulo;


    private String tarefa_detalhe;



    private LocalDateTime tarefa_prazo;

    private int tarefa_status;

    public int getTarefa_status() {
        return tarefa_status;
    }

    public void setTarefa_status(int tarefa_status) {
        this.tarefa_status = tarefa_status;
    }

    public int getTarefa_id() {
        return tarefa_id;
    }

    public void setTarefa_id(int tarefa_id) {
        this.tarefa_id = tarefa_id;
    }

    public int getMissao_id() {
        return missao_id;
    }

    public void setMissao_id(int missao_id) {
        this.missao_id = missao_id;
    }

    public String getTarefa_titulo() {
        return tarefa_titulo;
    }

    public void setTarefa_titulo(String tarefa_titulo) {
        this.tarefa_titulo = tarefa_titulo;
    }

    public String getTarefa_detalhe() {
        return tarefa_detalhe;
    }

    public void setTarefa_detalhe(String tarefa_detalhe) {
        this.tarefa_detalhe = tarefa_detalhe;
    }

    public LocalDateTime getTarefa_prazo() {
        return tarefa_prazo;
    }

    public void setTarefa_prazo(LocalDateTime tarefa_prazo) {
        this.tarefa_prazo = tarefa_prazo;
    }
}
