package com.senac.dei.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

public class MissaoDTOResponse {












    private int missao_id;




    private String missao_titulo;



    private LocalDateTime missao_prazo;
    private LocalDateTime missao_inicio;

    public LocalDateTime getMissao_inicio() {
        return missao_inicio;
    }

    public void setMissao_inicio(LocalDateTime missao_inicio) {
        this.missao_inicio = missao_inicio;
    }



    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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


}
