package com.sise.hotel_backend.reservaServicio.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.reservaServicio.domain.entities.ReservaServicio;

@Repository
public interface ReservaServicioRepository extends JpaRepository<ReservaServicio, Integer>{
    List<ReservaServicio> findByEstadoAuditoria(String estadoAuditoria);
    Optional<ReservaServicio> findByNombre(String nombre);

    @Modifying
    @Query("UPDATE ReservaServicio rs SET s.estadoAuditoria = '0' WHERE rs.idReservaServicio = :idReservaServicio")
    void darBajaReservaServicio(@Param("idReservaServicio") Integer idReservaServicio);
}
