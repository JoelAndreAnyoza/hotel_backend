package com.sise.hotel_backend.usuario.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.usuario.domain.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByNroDocumento(String nroDocumento);
}
