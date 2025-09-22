package com.sise.hotel_backend.servicio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.servicio.domain.entities.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

}
