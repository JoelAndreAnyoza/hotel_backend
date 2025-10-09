package com.sise.hotel_backend.habitacionComodidad.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.habitacionComodidad.domain.entities.HabitacionComodidad;

@Repository
public interface HabitacionComodidadRepository extends JpaRepository<HabitacionComodidad, Integer> {
    List<HabitacionComodidad> findByEstadoAuditoria(String estadoAuditoria);

    @Modifying
    @Query("UPDATE HabitacionComodidad hc SET hc.estadoAuditoria = '0' WHERE hc.idRelacion = :idRelacion")
    void darBajaHabitacionComodidad(@Param("idRelacion") Integer idRelacion);
}
