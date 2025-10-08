package com.sise.hotel_backend.tipoDocumento.domain.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.tipoDocumento.domain.entities.TipoDocumento;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer>{
    List<TipoDocumento> findByEstadoAuditoria(String estadoAuditoria);
    Optional<TipoDocumento> findByNombre(String nombre);
}
