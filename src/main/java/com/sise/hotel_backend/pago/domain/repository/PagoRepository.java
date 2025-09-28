package com.sise.hotel_backend.pago.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.pago.domain.entities.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer>{
    
}
