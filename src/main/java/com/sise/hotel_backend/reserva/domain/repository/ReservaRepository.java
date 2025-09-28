package com.sise.hotel_backend.reserva.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.reserva.domain.entities.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

    
}