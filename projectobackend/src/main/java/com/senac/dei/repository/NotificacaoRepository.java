package com.senac.dei.repository;

import com.senac.dei.entity.Notificacao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Integer> {

    @Query("SELECT n FROM Notificacao n WHERE n.status >= 0")
    List<Notificacao> listarNotificacoesAtivas();

    @Query("SELECT n FROM Notificacao n WHERE n.id = :id")
    Notificacao obterNotificacaoPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Notificacao n SET n.status = -1 WHERE n.id = :id")
    void apagarLogicoNotificacao(@Param("id") Integer notificacaoId);
}