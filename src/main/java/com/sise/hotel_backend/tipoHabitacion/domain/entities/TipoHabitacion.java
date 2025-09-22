package com.sise.hotel_backend.tipoHabitacion.domain.entities;

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
@Table(name = "tipos_habitacion")
public class TipoHabitacion {

    @Id
    @Column(name = "id_tipo_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoHabitacion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "precio_base")
    private Double precioBase;

    @Column(name = "estado_auditoria", insertable = false, updatable = false)
    private String estadoAuditoria;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}
