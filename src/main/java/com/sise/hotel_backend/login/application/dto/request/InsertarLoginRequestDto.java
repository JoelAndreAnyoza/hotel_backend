package com.sise.hotel_backend.login.application.dto.request;

import lombok.Data;

@Data
public class InsertarLoginRequestDto {
    private String usuario;
    private String contrasena;
    private String rol;
    private Integer idCliente;
    private Integer idEmpleado;
}
