package com.sise.hotel_backend.usuario.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.usuario.domain.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByNroDocumento(String nroDocumento);

    List<Usuario> findByEstadoAuditoria(String estadoAuditoria);
    Optional<Usuario> findByNombre(String nombre);

    @Modifying
    @Query("UPDATE Usuario u SET u.estadoAuditoria = '0' WHERE u.idUsuario = :idUsuario")
    void darBajaUsuario(@Param("idUsuario") Integer idUsuario);
}
