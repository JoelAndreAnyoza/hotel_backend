package com.sise.hotel_backend.habitacionComodidad.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.habitacionComodidad.domain.entities.HabitacionComodidad;

@Repository
public interface HabitacionComodidadRepository extends JpaRepository<HabitacionComodidad, Integer> {
    List<HabitacionComodidad> findByEstadoAuditoria(String estadoAuditoria);
    Optional<HabitacionComodidad> findByNombre(String nombre);

    @Modifying
    @Query("UPDATE HabitacionComodidad hc SET hc.estadoAuditoria = '0' WHERE hc.idHabitacionComodidad = :idHabitacionComodidad")
    void darBajaHabitacionComodidad(@Param("idHabitacionComodidad") Integer idHabitacionComodidad);
}
