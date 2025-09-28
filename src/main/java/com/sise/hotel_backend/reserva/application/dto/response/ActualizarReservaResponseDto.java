package com.sise.hotel_backend.reserva.application.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ActualizarReservaResponseDto {
    private Integer idReserva;
    private Integer idUsuario;
    private Integer idHabitacion;
    private Integer idEstadoReserva;
    private LocalDateTime fechaReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Integer numeroPersonas;
    private String codigoConfirmacion;
    private Double montoTotal;
    private String observaciones;
    private LocalDateTime fechaCreacion;
}
