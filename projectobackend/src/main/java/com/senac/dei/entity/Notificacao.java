package com.senac.dei.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "notificacao")
public class Notificacao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notificacao_id")
    private int notificacao_id;



    @Column(name = "notificacao_titulo")
    private String notificacao_titulo;

    @Column(name = "notificacao_detalhe")
    private String notificacao_detalhe;



//    @Temporal(TemporalType.DATE)
    @Column(name = "notificacao_prazo")
    private LocalDateTime notificacao_prazo;


    @Column(name="notificacao_diaria")
    private int notificacao_diaria;


//    @Temporal(TemporalType.TIME)
    @Column(name="notificacao_horario")
    private LocalDateTime notificacao_horario;


    @Column(name="notificacao_status")
    private int status;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    public int getNotificacao_id() {
        return notificacao_id;
    }

    public void setNotificacao_id(int notificacao_id) {
        this.notificacao_id = notificacao_id;
    }

    public String getNotificacao_titulo() {
        return notificacao_titulo;
    }

    public void setNotificacao_titulo(String notificacao_titulo) {
        this.notificacao_titulo = notificacao_titulo;
    }

    public String getNotificacao_detalhe() {
        return notificacao_detalhe;
    }

    public void setNotificacao_detalhe(String notificacao_detalhe) {
        this.notificacao_detalhe = notificacao_detalhe;
    }

    public LocalDateTime getNotificacao_prazo() {
        return notificacao_prazo;
    }

    public void setNotificacao_prazo(LocalDateTime notificacao_prazo) {
        this.notificacao_prazo = notificacao_prazo;
    }

    public int getNotificacao_diaria() {
        return notificacao_diaria;
    }

    public void setNotificacao_diaria(int notificacao_diaria) {
        this.notificacao_diaria = notificacao_diaria;
    }

    public LocalDateTime getNotificacao_horario() {
        return notificacao_horario;
    }

    public void setNotificacao_horario(LocalDateTime notificacao_horario) {
        this.notificacao_horario = notificacao_horario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
