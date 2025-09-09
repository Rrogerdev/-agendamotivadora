package com.senac.dei.repository;

import com.senac.dei.entity.Missao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MissaoRepository extends JpaRepository<Missao, Integer> {


    @Modifying
    @Transactional
    @Query("UPDATE Missao m SET m.status = -1 WHERE m.id = :id")
    void apagarLogicoMissao(@Param("id") Integer missaoId);

}
