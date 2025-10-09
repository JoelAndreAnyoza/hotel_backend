package com.sise.hotel_backend.servicio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.servicio.domain.entities.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    List<Servicio> findByEstadoAuditoria(String estadoAuditoria);

    @Modifying
    @Query("UPDATE Servicio s SET s.estadoAuditoria = '0' WHERE s.idServicio = :idServicio")
    void darBajaServicio(@Param("idServicio") Integer idServicio);
}
