package com.sise.hotel_backend.login.domain.entities;

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
@Table(name = "login")
public class Login {

    @Id
    @Column(name = "id_login")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLogin;

    @Column(name = "usuario", unique = true)
    private String usuario;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "rol")
    private String rol;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "estado_auditoria", insertable = false, updatable = false)
    private Boolean estadoAuditoria = true;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}
