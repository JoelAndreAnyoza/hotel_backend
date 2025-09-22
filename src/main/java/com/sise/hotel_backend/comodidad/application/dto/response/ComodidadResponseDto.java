package com.sise.hotel_backend.comodidad.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ComodidadResponseDto {
    private Integer idComodidad;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
}
