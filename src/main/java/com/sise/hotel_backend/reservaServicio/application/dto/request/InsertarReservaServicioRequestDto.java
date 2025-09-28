package com.sise.hotel_backend.reservaServicio.application.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class InsertarReservaServicioRequestDto {
    @NotNull
    private Integer idReserva;

    @NotNull
    private Integer idServicio;

    @NotNull
    @Positive
    private Integer cantidad;

    @NotNull
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que 0")
    @Digits(integer = 10, fraction = 2, message = "El precio debe tener máximo 10 enteros y 2 decimales")
    private Double subtotal;
}
