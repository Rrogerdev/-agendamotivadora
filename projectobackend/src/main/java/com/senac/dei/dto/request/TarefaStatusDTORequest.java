package com.senac.dei.dto.request;

public class TarefaStatusDTORequest {

    public int getTarefa_id() {
        return tarefa_id;
    }

    public void setTarefa_id(int tarefa_id) {
        this.tarefa_id = tarefa_id;
    }

    public int getTarefa_status() {
        return tarefa_status;
    }

    public void setTarefa_status(int tarefa_status) {
        this.tarefa_status = tarefa_status;
    }

    private int tarefa_id;

    private int tarefa_status;
}