package com.senac.dei.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="missao_id")
    private int missao_id;



    @Column(name = "missao_titulo")
    private String missao_titulo;



    @Temporal(TemporalType.DATE)
    @Column(name = "missao_prazo")
    private LocalDateTime missao_prazo;


    @OneToMany(mappedBy = "tarefa")
    private Set<Tarefa> tarefas;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "meta_id", nullable = false)
    private int meta_id;




    public LocalDateTime getMissao_inicio() {
        return missao_inicio;
    }

    public void setMissao_inicio(LocalDateTime missao_inicio) {
        this.missao_inicio = missao_inicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "missao_inicio")
    private LocalDateTime missao_inicio;

    @Column(name="missao_status")
    private int missao_status;
}
