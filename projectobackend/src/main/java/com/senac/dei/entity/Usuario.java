package com.senac.dei.entity;

import jakarta.persistence.*;

import java.util.Set;

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int usuario_id;

    @Column(name = "usuario_nome")
    private String usuario_nome;

    @Column(name = "usuario_email")
    private String usuario_email;


    @Column(name = "usuario_senha")
    private String usuario_senha;


    @Column(name = "usuario_status")
    private String usuario_status;

    @OneToMany(mappedBy = "usuario")
    private Set <Meta> metas;

    @OneToMany(mappedBy = "notificacao")
    private Set <Notificacao> notificacoes;

}
