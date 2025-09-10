package com.senac.dei.dto.request;

public class NotificacaoDTOUpdateRequest {

    private int notificacao_id;

    private int notificacao_status;

    public int getNotificacao_id() {
        return notificacao_id;
    }

    public void setNotificacao_id(int notificacao_id) {
        this.notificacao_id = notificacao_id;
    }

    public int getNotificacao_status() {
        return notificacao_status;
    }

    public void setNotificacao_status(int notificacao_status) {
        this.notificacao_status = notificacao_status;
    }
}
