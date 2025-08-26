package com.senac.dei.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="meta_id")
    private int meta_id;

    @Column(name = "usuario_id")
    private int usuario_id;

    @Column(name = "meta_titulo")
    private String meta_titulo;

    @Column(name = "missao_detalhe")
    private String meta_detalhe;

    @Temporal(TemporalType.DATE)
    @Column(name = "meta_prazo")
    private LocalDateTime meta_prazo;


    @Temporal(TemporalType.DATE)
    @Column(name = "meta_inicio")
    private LocalDateTime missao_inicio;

    public int getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(int meta_id) {
        this.meta_id = meta_id;
    }

    @Column(name="meta_status")
    private int meta_status;
}
