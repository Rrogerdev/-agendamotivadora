package com.senac.dei.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "missao")
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="missao_id")
    private int missao_id;



    @Column(name = "missao_titulo")
    private String missao_titulo;



//    @Temporal(TemporalType.DATE)
    @Column(name = "missao_prazo")
    private LocalDateTime missao_prazo;


    @OneToMany(mappedBy = "tarefa_id")
    private Set<Tarefa> tarefas;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "meta_id", nullable = false)
        private Meta meta;


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

    public Set<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(Set<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getMissao_inicio() {
        return missao_inicio;
    }

    public void setMissao_inicio(LocalDateTime missao_inicio) {
        this.missao_inicio = missao_inicio;
    }

//    @Temporal(TemporalType.DATE)
    @Column(name = "missao_inicio")
    private LocalDateTime missao_inicio;

    @Column(name="missao_status")
    private int status;
}
