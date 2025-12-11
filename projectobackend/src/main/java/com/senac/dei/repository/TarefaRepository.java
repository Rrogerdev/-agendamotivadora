package com.senac.dei.repository;


import com.senac.dei.entity.Tarefa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{


    @Modifying
    @Transactional
    @Query("UPDATE Tarefa t SET t.status = :status WHERE t.id = :id")
    void atualizarStatusTarefa(@Param("id") Integer tarefaId, @Param("status") Integer tarefaStatus);

    @Modifying
    @Transactional
    @Query("UPDATE Tarefa t SET t.status = -1 WHERE t.id = :id")
    void apagarLogicoTarefa(@Param("id") Integer tarefaId);
}
