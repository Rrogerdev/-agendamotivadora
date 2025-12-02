package com.senac.dei.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.dei.entity.Missao;
import com.senac.dei.entity.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

public class MetaDTORequest {




    private String meta_titulo;


    private String meta_detalhe;


    private LocalDateTime meta_prazo;

    public LocalDateTime getMeta_inicio() {
        return meta_inicio;
    }

    public void setMeta_inicio(LocalDateTime meta_inicio) {
        this.meta_inicio = meta_inicio;
    }

    private LocalDateTime meta_inicio;


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









    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    private int usuario_id;

}
