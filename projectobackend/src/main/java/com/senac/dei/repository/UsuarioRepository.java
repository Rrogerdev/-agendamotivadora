package com.senac.dei.repository;
import com.senac.dei.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {



    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.status = -1 WHERE u.id = :id")
    void apagarLogicoUsuario(@Param("id") Integer usuarioId);

    @Query("SELECT u FROM Usuario u WHERE u.usuario_email = :email")
    Optional<Usuario> findByusuario_email(String email);
}
