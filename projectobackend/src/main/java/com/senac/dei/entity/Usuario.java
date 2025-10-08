package com.senac.dei.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int usuario_id;


    @Column(name = "usuario_nome")
    private String usuario_nome;




    @Column(name = "usuario_email", nullable = false)
    private String usuario_email;


    @Column(name = "usuario_senha")
    private String usuario_senha;


    @Column(name = "usuario_status")
    private int status;

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_nome() {
        return usuario_nome;
    }

    public void setUsuario_nome(String usuario_nome) {
        this.usuario_nome = usuario_nome;
    }

    public String getUsuario_email() {
        return usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    public String getUsuario_senha() {
        return usuario_senha;
    }

    public void setUsuario_senha(String usuario_senha) {
        this.usuario_senha = usuario_senha;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Meta> getMetas() {
        return metas;
    }

    public void setMetas(Set<Meta> metas) {
        this.metas = metas;
    }

    public Set<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(Set<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }

    @OneToMany(mappedBy = "meta_id")
    private Set <Meta> metas;

    @OneToMany(mappedBy = "notificacao_id")
    private Set <Notificacao> notificacoes;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="usuario_role",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;

}
