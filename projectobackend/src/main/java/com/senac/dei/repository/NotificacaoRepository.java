package com.senac.dei.repository;

import com.senac.dei.entity.Notificacao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Integer> {



    @Modifying
    @Transactional
    @Query("UPDATE Notificacao n SET n.status = -1 WHERE n.id = :id")
    void apagarLogicoNotificacao(@Param("id") Integer notificacaoId);
}