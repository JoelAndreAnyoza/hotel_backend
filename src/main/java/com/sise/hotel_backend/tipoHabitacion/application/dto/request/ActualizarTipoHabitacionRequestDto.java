package com.sise.hotel_backend.tipoHabitacion.application.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ActualizarTipoHabitacionRequestDto {
    @NotBlank
    @Size(min = 1, max = 50)
    private String nombre;
    private String descripcion;

    @NotNull
    @Min(value = 1, message = "La capacidad mínima es 1 persona")
    @Max(value = 8, message = "La capacidad máxima permitida es 8 personas")
    private Integer capacidad;

    @NotNull
    @DecimalMin(value = "0.01", message = "El precio base debe ser mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "El precio base debe tener máximo 10 enteros y 2 decimales")
    private Double precioBase;
}
