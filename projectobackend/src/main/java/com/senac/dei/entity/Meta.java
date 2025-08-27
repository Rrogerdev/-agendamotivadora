package com.senac.dei.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="meta_id")
    private int meta_id;



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

    @Column(name="meta_status")
    private int meta_status;
}
