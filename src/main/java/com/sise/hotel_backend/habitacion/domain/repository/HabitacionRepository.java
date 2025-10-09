package com.sise.hotel_backend.habitacion.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.habitacion.domain.entities.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    List<Habitacion> findByEstadoAuditoria(String estadoAuditoria);
    Optional<Habitacion> findByNombre(String nombre);

    @Modifying
    @Query("UPDATE Habitacion h SET h.estadoAuditoria = '0' WHERE h.idHabitacion = :idHabitacion")
    void darBajaHabitacion(@Param("idHabitacion") Integer idHabitacion);
}
