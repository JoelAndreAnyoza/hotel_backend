package com.sise.hotel_backend.tipoHabitacion.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sise.hotel_backend.tipoHabitacion.domain.entities.TipoHabitacion;

@Repository
public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer>{
    List<TipoHabitacion> findByEstadoAuditoria(String estadoAuditoria);
    Optional<TipoHabitacion> findByNombre(String nombre);

    @Modifying
    @Query("UPDATE TipoHabitacion th SET th.estadoAuditoria = '0' WHERE th.idTipoHabitacion = :idTipoHabitacion")
    void darBajaTipoHabitacion(@Param("idTipoHabitacion") Integer idTipoHabitacion);
}

