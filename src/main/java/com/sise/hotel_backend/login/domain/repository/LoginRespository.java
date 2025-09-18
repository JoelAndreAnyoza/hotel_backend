package com.sise.hotel_backend.login.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.login.domain.entities.Login;

@Repository
public interface LoginRespository extends JpaRepository<Login, Integer>{ //referencia a la entidad
    
}
