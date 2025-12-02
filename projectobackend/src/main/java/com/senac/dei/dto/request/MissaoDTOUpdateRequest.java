package com.senac.dei.dto.request;

public class MissaoDTOUpdateRequest {


    private int missao_id;

    public int getMissao_id() {
        return missao_id;
    }

    public void setMissao_id(int missao_id) {
        this.missao_id = missao_id;
    }

    public int getMissao_status() {
        return missao_status;
    }

    public void setMissao_status(int missao_status) {
        this.missao_status = missao_status;
    }

    private int missao_status;

}
