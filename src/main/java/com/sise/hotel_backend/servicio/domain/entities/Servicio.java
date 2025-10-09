package com.sise.hotel_backend.servicio.domain.entities;

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
@Table(name = "servicios")
public class Servicio {

    @Id
    @Column(name = "id_servicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "estado_auditoria", insertable = false, updatable = false)
    private String estadoAuditoria;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}
