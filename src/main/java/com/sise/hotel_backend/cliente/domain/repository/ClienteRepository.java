package com.sise.hotel_backend.cliente.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.cliente.domain.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{ //referncia a la entidad
    
}
