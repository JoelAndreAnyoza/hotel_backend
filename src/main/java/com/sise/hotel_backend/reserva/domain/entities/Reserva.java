package com.sise.hotel_backend.reserva.domain.entities;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
@Table(name = "Reserva")
public class Reserva {

    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @OneToMany
    @Column(name = "id_cliente")
    private Cliente idCliente;

    @OneToMany
    @Column(name = "id_habitacion")
    private Habitacion idHabitacion;

    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;

    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "monto_total")
    private Double montoTotal;

    @Columun(name = "estado_auditoria", insertable = false, updatable = false)
    private String estadoAuditoria;
}