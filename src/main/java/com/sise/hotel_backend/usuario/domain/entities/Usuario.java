package com.sise.hotel_backend.usuario.domain.entities;

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
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "nro_documento")
    private String nroDocumento;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "estado_auditoria", insertable = false, updatable = false)
    private String estadoAuditoria;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}
