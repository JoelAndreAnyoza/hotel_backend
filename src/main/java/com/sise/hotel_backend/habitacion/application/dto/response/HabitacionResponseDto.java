package com.sise.hotel_backend.habitacion.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HabitacionResponseDto {
    private Integer idHabitacion;
    private Integer idTipoHabitacion;
    private Integer idEstadoHabitacion;
    private String numeroHabitacion;
    private Integer piso;
    private LocalDateTime fechaCreacion;
}
