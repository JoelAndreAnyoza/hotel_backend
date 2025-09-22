package com.sise.hotel_backend.servicio.application.dto.request;

import lombok.Data;

@Data
public class ServicioRequestDto {
    private String nombre;
    private String descripcion;
    private Double precio;
}
