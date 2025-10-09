package com.sise.hotel_backend.reserva.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.reserva.domain.entities.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

    List<Reserva> findByEstadoAuditoria(String estadoAuditoria);
    Optional<Reserva> findByNombre(String nombre);

    @Modifying
    @Query("UPDATE Reserva r SET r.estadoAuditoria = '0' WHERE r.idReserva = :idReserva")
    void darBajaReserva(@Param("idReserva") Integer idReserva);
}