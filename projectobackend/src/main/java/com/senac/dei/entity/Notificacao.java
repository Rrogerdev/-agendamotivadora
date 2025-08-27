package com.senac.dei.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

public class Notificacao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notificacao_id")
    private int notificacao_id;



    @Column(name = "notificacao_titulo")
    private String notificacao_titulo;

    @Column(name = "notificacao_detalhe")
    private String notificacao_detalhe;



    @Temporal(TemporalType.DATE)
    @Column(name = "notificacao_prazo")
    private LocalDateTime notificacao_prazo;


    @Column(name="notificacao_diaria")
    private int notificacao_diaria;


    @Temporal(TemporalType.TIME)
    @Column(name="notificacao_horario")
    private int notificacao_horario;


    @Column(name="notificacao_status")
    private int notificacao_status;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id", nullable = false)
    private int usuario_id;
}
