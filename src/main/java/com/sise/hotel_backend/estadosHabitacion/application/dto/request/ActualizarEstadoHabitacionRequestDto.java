package com.sise.hotel_backend.estadosHabitacion.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ActualizarEstadoHabitacionRequestDto {
    @NotBlank // No puede estar vacío
    @Size(min = 1, max = 50) // Debe tener entre 1 y 50 caracteres
    private String nombre;
}
