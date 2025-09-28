package com.sise.hotel_backend.reserva.domain.entities;

import java.time.LocalDate;
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
@Table(name = "reservas")
public class Reserva {

    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "id_estado_reserva")
    private Integer idEstadoReserva;

    @Column(name = "fecha_reserva", insertable = false, updatable = false)
    private LocalDateTime fechaReserva;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;
    
    @Column(name = "numero_personas")
    private Integer numeroPersonas;
    
    @Column(name = "codigo_confirmacion", insertable = false, updatable = false, unique = true)
    private String codigoConfirmacion;

    @Column(name = "monto_total")
    private Double montoTotal;

    @Column(name = "observaciones", nullable = true)
    private String observaciones;

    @Column(name = "estado_auditoria", insertable = false, updatable = false)
    private String estadoAuditoria;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}