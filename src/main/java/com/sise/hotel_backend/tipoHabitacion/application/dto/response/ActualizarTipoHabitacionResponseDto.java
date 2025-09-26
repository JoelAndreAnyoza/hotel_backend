package com.sise.hotel_backend.tipoHabitacion.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ActualizarTipoHabitacionResponseDto {
    private Integer idTipoHabitacion;
    private String nombre;
    private String descripcion;
    private Integer capacidad;
    private Double precioBase;
    private LocalDateTime fechaCreacion;
}
