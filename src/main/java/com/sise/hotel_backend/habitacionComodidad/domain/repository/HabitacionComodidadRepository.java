package com.sise.hotel_backend.habitacionComodidad.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.habitacionComodidad.domain.entities.HabitacionComodidad;

@Repository
public interface HabitacionComodidadRepository extends JpaRepository<HabitacionComodidad, Integer> {
    
}
