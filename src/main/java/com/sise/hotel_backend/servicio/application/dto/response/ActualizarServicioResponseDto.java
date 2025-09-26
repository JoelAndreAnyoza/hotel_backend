package com.sise.hotel_backend.servicio.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ActualizarServicioResponseDto {
    private Integer idServicio;
    private String nombre;
    private String descripcion;
    private Double precio;
    private LocalDateTime fechaCreacion;
}
