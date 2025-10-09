package com.sise.hotel_backend.metodoPago.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.metodoPago.domain.entities.MetodoPago;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {
    List<MetodoPago> findByEstadoAuditoria(String estadoAuditoria);
    Optional<MetodoPago> findByNombre(String nombre);

    @Modifying
    @Query("UPDATE MetodoPago m SET m.estadoAuditoria = '0' WHERE m.idMetodoPago = :idMetodoPago")
    void darBajaMetodoPago(@Param("idMetodoPago") Integer idMetodoPago);
}
