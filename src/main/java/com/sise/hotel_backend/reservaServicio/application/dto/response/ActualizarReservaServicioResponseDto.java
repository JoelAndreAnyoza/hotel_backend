package com.sise.hotel_backend.reservaServicio.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ActualizarReservaServicioResponseDto {
    private Integer idReservaServicio;
    private Integer idReserva;
    private Integer idServicio;
    private Integer cantidad;
    private Double subtotal;
    private LocalDateTime fechaCreacion;
}
