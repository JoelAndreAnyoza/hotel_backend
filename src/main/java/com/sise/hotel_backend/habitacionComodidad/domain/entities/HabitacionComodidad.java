package com.sise.hotel_backend.habitacionComodidad.domain.entities;

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
@Table(name = "habitacion_comodidades")
public class HabitacionComodidad {

    @Id
    @Column(name = "id_relacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRelacion;

    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "id_comodidad")
    private Integer idComodidad;

    @Column(name = "estado_auditoria", insertable = false, updatable = false)
    private String estadoAuditoria;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}
