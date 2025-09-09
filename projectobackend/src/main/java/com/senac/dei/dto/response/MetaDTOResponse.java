package com.senac.dei.dto.response;

import java.time.LocalDateTime;

public class MetaDTOResponse {






    private int meta_id;




    private String meta_titulo;


    private String meta_detalhe;


    private LocalDateTime meta_prazo;



    private LocalDateTime missao_inicio;

    public int getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(int meta_id) {
        this.meta_id = meta_id;
    }

    public String getMeta_titulo() {
        return meta_titulo;
    }

    public void setMeta_titulo(String meta_titulo) {
        this.meta_titulo = meta_titulo;
    }

    public String getMeta_detalhe() {
        return meta_detalhe;
    }

    public void setMeta_detalhe(String meta_detalhe) {
        this.meta_detalhe = meta_detalhe;
    }

    public LocalDateTime getMeta_prazo() {
        return meta_prazo;
    }

    public void setMeta_prazo(LocalDateTime meta_prazo) {
        this.meta_prazo = meta_prazo;
    }

    public LocalDateTime getMissao_inicio() {
        return missao_inicio;
    }

    public void setMissao_inicio(LocalDateTime missao_inicio) {
        this.missao_inicio = missao_inicio;
    }
}
