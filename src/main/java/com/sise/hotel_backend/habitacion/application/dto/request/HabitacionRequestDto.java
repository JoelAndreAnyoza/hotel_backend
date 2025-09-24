package com.sise.hotel_backend.habitacion.application.dto.request;

import lombok.Data;

@Data
public class HabitacionRequestDto {
    private Integer idTipoHabitacion;
    private Integer idEstadoHabitacion;
    private String numeroHabitacion;
    private Integer piso;
}
