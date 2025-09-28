package com.sise.hotel_backend.habitacionComodidad.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ActualizarHabitacionComodidadRequestDto {
    @NotNull
    @Positive
    private Integer idHabitacion;
    
    @NotNull
    @Positive
    private Integer idComodidad;
}
