package com.sise.hotel_backend.pago.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.hotel_backend.pago.domain.entities.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer>{
    List<Pago> findByEstadoAuditoria(String estadoAuditoria);
    Optional<Pago> findByNombre(String nombre);

    @Modifying
    @Query("UPDATE Pago p SET p.estadoAuditoria = '0' WHERE p.idPago = :idPago")
    void darBajaPago(@Param("idPago") Integer idPago);
}
