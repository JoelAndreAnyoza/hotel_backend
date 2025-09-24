package com.sise.hotel_backend.estadosHabitacion.domain.entities;

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
@Table(name = "estados_habitacion")
public class EstadosHabitacion {
    
    @Id
    @Column(name = "id_estado_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoHabitacion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado_auditoria", insertable = false, updatable = false)
    private String estadoAuditoria;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}
