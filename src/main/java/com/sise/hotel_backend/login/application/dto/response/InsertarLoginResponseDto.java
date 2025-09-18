package com.sise.hotel_backend.login.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class InsertarLoginResponseDto {
    private Integer idLogin;
    private String usuario;
    private String contrasena;
    private String rol;
    private Integer idCliente;
    private Integer idEmpleado;
    private LocalDateTime fechaCreacion;
}
