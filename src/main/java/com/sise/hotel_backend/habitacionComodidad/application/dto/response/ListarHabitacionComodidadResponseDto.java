package com.sise.hotel_backend.habitacionComodidad.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ListarHabitacionComodidadResponseDto {
    private Integer idRelacion;
    private Integer idHabitacion;
    private Integer idComodidad;
    private LocalDateTime fechaCreacion;
}
