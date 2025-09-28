package com.sise.hotel_backend.pago.application.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ActualizarPagoRequestDto {
    @NotNull
    private Integer idReserva;
    
    @NotNull
    private Integer idMetodoPago;

    @NotNull
    @FutureOrPresent(message = "La fecha de pago puede ser hoy o en el futuro")
    private LocalDate fechaPago;

    @NotNull
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que 0")
    @Digits(integer = 10, fraction = 2, message = "El precio debe tener máximo 10 enteros y 2 decimales")
    private Double monto;

    @NotBlank
    @Size(max = 20, message = "El estado del pago no puede tener más de 20 caracteres")
    private String estadoPago;
}
