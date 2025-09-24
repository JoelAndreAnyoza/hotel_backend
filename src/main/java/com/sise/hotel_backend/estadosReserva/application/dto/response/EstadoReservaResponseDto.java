package com.sise.hotel_backend.estadosReserva.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EstadoReservaResponseDto {
    private Integer idEstadoReserva;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
}
