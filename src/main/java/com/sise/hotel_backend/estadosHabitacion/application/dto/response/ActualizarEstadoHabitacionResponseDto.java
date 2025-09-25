package com.sise.hotel_backend.estadosHabitacion.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ActualizarEstadoHabitacionResponseDto {
    private Integer idEstadoHabitacion;
    private String nombre;
    private LocalDateTime fechaCreacion;
}
