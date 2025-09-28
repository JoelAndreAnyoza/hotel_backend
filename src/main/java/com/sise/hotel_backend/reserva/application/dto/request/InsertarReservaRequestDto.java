package com.sise.hotel_backend.reserva.application.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class InsertarReservaRequestDto {
    @NotNull
    private Integer idUsuario;

    @NotNull
    private Integer idHabitacion;

    @NotNull
    private Integer idEstadoReserva;

    @NotNull
    @FutureOrPresent(message = "La fecha de ingreso debe ser hoy o en el futuro")
    private LocalDate fechaIngreso;

    @NotNull
    @Future(message = "La fecha de salida debe ser futura")
    private LocalDate fechaSalida;

    @NotNull
    @Positive
    private Integer numeroPersonas;

    @NotNull
    @Positive
    private Double montoTotal;

    private String observaciones;
}
