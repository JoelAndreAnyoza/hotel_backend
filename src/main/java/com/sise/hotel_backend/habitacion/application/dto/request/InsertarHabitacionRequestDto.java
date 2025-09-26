package com.sise.hotel_backend.habitacion.application.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertarHabitacionRequestDto {
    @NotNull //campo obligatorio
    @Positive //el campo debe ser un numero positivo
    private Integer idTipoHabitacion;

    @NotNull
    @Positive
    private Integer idEstadoHabitacion;

    @NotBlank 
    @Size(min = 1, max = 10)
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "El número de habitación solo puede contener letras y números")
    private String numeroHabitacion;

    @NotNull
    @Min(value = 1)
    @Max(value = 20)
    private Integer piso;
}
