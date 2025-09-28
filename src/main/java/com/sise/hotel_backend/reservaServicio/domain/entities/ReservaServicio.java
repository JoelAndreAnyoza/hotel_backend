package com.sise.hotel_backend.reservaServicio.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas_servicio")
public class ReservaServicio {

    @Id
    @Column(name = "id_reserva_servicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservaServicio;

    @Column(name = "id_reserva")
    private Integer idReserva;

    @Column(name = "id_servicio")
    private Integer idServicio;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "estado_auditoria", insertable = false, updatable = false)
    private String estadoAuditoria;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}
