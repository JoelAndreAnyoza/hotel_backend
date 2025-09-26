package com.sise.hotel_backend.metodoPago.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ListarMetodoPagoResponseDto {
    private Integer idMetodoPago;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
}
