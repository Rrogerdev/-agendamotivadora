package com.senac.dei.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "meta")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="meta_id")
    private int meta_id;



    @Column(name = "meta_titulo")
    private String meta_titulo;

    @Column(name = "meta_detalhe")
    private String meta_detalhe;

//    @Temporal(TemporalType.DATE)
    @Column(name = "meta_prazo")
    private LocalDateTime meta_prazo;


//    @Temporal(TemporalType.DATE)
    @Column(name = "meta_inicio")
    private LocalDateTime meta_inicio;

    @Column(name="meta_status")
    private int status;

    @OneToMany(mappedBy = "meta")
    private Set<Missao> missoes;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public int getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(int meta_id) {
        this.meta_id = meta_id;
    }

    public String getMeta_titulo() {
        return meta_titulo;
    }

    public void setMeta_titulo(String meta_titulo) {
        this.meta_titulo = meta_titulo;
    }

    public String getMeta_detalhe() {
        return meta_detalhe;
    }

    public void setMeta_detalhe(String meta_detalhe) {
        this.meta_detalhe = meta_detalhe;
    }

    public LocalDateTime getMeta_prazo() {
        return meta_prazo;
    }

    public void setMeta_prazo(LocalDateTime meta_prazo) {
        this.meta_prazo = meta_prazo;
    }

    public LocalDateTime getMeta_inicio() {
        return meta_inicio;
    }

    public void setMeta_inicio(LocalDateTime meta_inicio) {
        this.meta_inicio = meta_inicio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Missao> getMissoes() {
        return missoes;
    }

    public void setMissoes(Set<Missao> missoes) {
        this.missoes = missoes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
