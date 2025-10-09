package com.sise.hotel_backend.comodidad.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.comodidad.domain.entities.Comodidad;

@Repository
public interface ComodidadRepository extends JpaRepository<Comodidad, Integer> {
    List<Comodidad> findByEstadoAuditoria(String estadoAuditoria);
    Optional<Comodidad> findByNombre(String nombre);

    @Modifying
    @Query("UPDATE Comodidad c SET c.estadoAuditoria = '0' WHERE c.idComodidad = :idComodidad")
    void darBajaComodidad(@Param("idComodidad") Integer idComodidad);
}
