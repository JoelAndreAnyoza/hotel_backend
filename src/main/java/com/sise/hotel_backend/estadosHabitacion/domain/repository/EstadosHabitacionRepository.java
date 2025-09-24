package com.sise.hotel_backend.estadosHabitacion.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.estadosHabitacion.domain.entities.EstadosHabitacion;

@Repository
public interface EstadosHabitacionRepository extends JpaRepository<EstadosHabitacion, Integer>{
    
}
