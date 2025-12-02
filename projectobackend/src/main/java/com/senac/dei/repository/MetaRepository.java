package com.senac.dei.repository;


import com.senac.dei.entity.Meta;
import com.senac.dei.entity.Missao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Integer> {


    @Modifying
    @Transactional
    @Query("UPDATE Meta m SET m.status = -1 WHERE m.id = :id")
    void apagarLogicoMeta(@Param("id") Integer metaId);

    @Query("SELECT DISTINCT m FROM Meta m WHERE m.usuario.id = :usuario_id")
    List<Meta> obterMetasPorUsuario(@Param("usuario_id") Integer usuarioId);







    @Query("SELECT COUNT (*) m FROM Meta m WHERE m.usuario.id = :usuario_id")
    int MetasCountPorUsuario(@Param("usuario_id") Integer usuarioId);
}
