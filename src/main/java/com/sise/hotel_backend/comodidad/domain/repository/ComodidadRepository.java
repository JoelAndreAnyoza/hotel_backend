package com.sise.hotel_backend.comodidad.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.comodidad.domain.entities.Comodidad;

@Repository
public interface ComodidadRepository extends JpaRepository<Comodidad, Integer> {

}
