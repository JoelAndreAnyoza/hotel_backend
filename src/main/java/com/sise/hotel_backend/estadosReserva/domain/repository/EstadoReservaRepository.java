package com.sise.hotel_backend.estadosReserva.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.estadosReserva.domain.entities.EstadoReserva;

@Repository
public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Integer>{
    List<EstadoReserva> findByEstadoAuditoria(String estadoAuditoria);
    Optional<EstadoReserva> findByNombre(String nombre);

    @Modifying
    @Query("UPDATE EstadoReserva er SET er.estadoAuditoria = '0' WHERE er.idEstadoReserva = :idEstadoReserva")
    void darBajaEstadoReserva(@Param("idEstadoReserva") Integer idEstadoReserva);
}
