package com.sise.hotel_backend.tipoHabitacion.application.dto.request;

import lombok.Data;

@Data
public class TipoHabitacionRequestDto {
    private String nombre;
    private String descripcion;
    private Integer capacidad;
    private Double precioBase;
}
