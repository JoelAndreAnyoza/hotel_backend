package com.sise.hotel_backend.cliente.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class InsertarClienteResponseDto {
    private Integer idCliente;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private String numeroDocumento;
    private String email;
    private String telefono;
    private String direccion;
    private LocalDateTime fechaCreacion;
}
