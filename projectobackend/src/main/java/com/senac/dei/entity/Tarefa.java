package com.senac.dei.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tarefa")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tarefa_id")
    private int tarefa_id;


    @Column(name = "tarefa_titulo")
    private String tarefa_titulo;

    @Column(name = "tarefa_detalhe")
    private String tarefa_detalhe;


//    @Temporal(TemporalType.DATE)
    @Column(name = "tarefa_prazo")
    private LocalDateTime tarefa_prazo;


//    @Temporal(TemporalType.DATE)
    @Column(name = "tarefa_inicio")
    private LocalDateTime tarefa_inicio;


    @Column(name="tarefa_status")
    private int status;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="missao_id", nullable = false)
    private Missao missao;

    public int getTarefa_id() {
        return tarefa_id;
    }

    public void setTarefa_id(int tarefa_id) {
        this.tarefa_id = tarefa_id;
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

    public LocalDateTime getTarefa_inicio() {
        return tarefa_inicio;
    }

    public void setTarefa_inicio(LocalDateTime tarefa_inicio) {
        this.tarefa_inicio = tarefa_inicio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Missao getMissao() {
        return missao;
    }

    public void setMissao(Missao missao) {
        this.missao = missao;
    }
}
