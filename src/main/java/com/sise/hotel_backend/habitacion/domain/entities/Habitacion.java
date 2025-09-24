package com.sise.hotel_backend.habitacion.domain.entities;

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
@Table(name = "habitaciones")
public class Habitacion {
    
    @Id
    @Column(name = "id_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHabitacion;

    @Column(name = "id_tipo_habitacion")
    private Integer idTipoHabitacion;

    @Column(name = "id_estado_habitacion")
    private Integer idEstadoHabitacion;

    @Column(name = "numero_habitacion")
    private String numeroHabitacion;

    @Column(name = "piso")
    private Integer piso;

    @Column(name = "estado_auditoria", insertable = false, updatable = false)
    private String estadoAuditoria;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}
