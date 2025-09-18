package com.sise.hotel_backend.cliente.application.dto.request;

import lombok.Data;

@Data
public class InsertarClienteRequestDto {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private String numeroDocumento;
    private String email;
    private String telefono;
    private String direccion;
}
