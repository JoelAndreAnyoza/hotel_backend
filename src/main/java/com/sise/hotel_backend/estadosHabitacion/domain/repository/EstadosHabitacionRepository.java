package com.sise.hotel_backend.estadosHabitacion.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.estadosHabitacion.domain.entities.EstadosHabitacion;

@Repository
public interface EstadosHabitacionRepository extends JpaRepository<EstadosHabitacion, Integer>{
    List<EstadosHabitacion> findByEstadoAuditoria(String estadoAuditoria);
    Optional<EstadosHabitacion> findByNombre(String nombre);

    @Modifying
    @Query("UPDATE EstadosHabitacion eh SET eh.estadoAuditoria = '0' WHERE eh.idEstadoHabitacion = :idEstadoHabitacion")
    void darBajaEstadoHabitacion(@Param("idEstadoHabitacion") Integer idEstadoHabitacion);
}
