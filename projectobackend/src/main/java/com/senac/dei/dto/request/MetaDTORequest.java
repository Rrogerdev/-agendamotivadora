package com.senac.dei.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.dei.entity.Missao;
import com.senac.dei.entity.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

public class MetaDTORequest {





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

    public Set<Missao> getMissoes() {
        return missoes;
    }

    public void setMissoes(Set<Missao> missoes) {
        this.missoes = missoes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private Set<Missao> missoes;



    private Usuario usuario;
}
