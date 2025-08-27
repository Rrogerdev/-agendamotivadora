package com.senac.dei.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tarefa_id")
    private int tarefa_id;

    @Column(name = "missao_id")
    private int missao_id;

    @Column(name = "tarefa_titulo")
    private String tarefa_titulo;

    @Column(name = "tarefa_detalhe")
    private String tarefa_detalhe;


    @Temporal(TemporalType.DATE)
    @Column(name = "tarefa_prazo")
    private LocalDateTime tarefa_prazo;


    @Temporal(TemporalType.DATE)
    @Column(name = "tarefa_inicio")
    private LocalDateTime tarefa_inicio;


    @Column(name="tarefa_status")
    private int tarefa_status;

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








}
