package com.senac.dei.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.dei.entity.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class NotificacaoDTOResponse {










    private int notificacao_id;




    private String notificacao_titulo;


    private String notificacao_detalhe;




    private LocalDateTime notificacao_prazo;



    private int notificacao_diaria;



    private LocalDateTime notificacao_horario;



    private int status;

    private int usuario_id;

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

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
}
