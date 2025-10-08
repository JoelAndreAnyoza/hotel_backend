package com.sise.hotel_backend.tipoDocumento.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data //para los get y set
@Entity
@Table(name = "tipos_documento")
public class TipoDocumento {
    
    @Id
    @Column(name = "id_tipo_documento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoDocumento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "estado_auditoria", insertable = false, updatable = true)
    private String estadoAuditoria;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}
