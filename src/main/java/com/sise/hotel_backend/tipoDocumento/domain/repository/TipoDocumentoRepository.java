package com.sise.hotel_backend.tipoDocumento.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.tipoDocumento.domain.entities.TipoDocumento;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer>{
    
}
