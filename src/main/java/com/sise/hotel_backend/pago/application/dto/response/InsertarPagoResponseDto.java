package com.sise.hotel_backend.pago.application.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class InsertarPagoResponseDto {
    private Integer idPago;
    private Integer idReserva;
    private Integer idMetodoPago;
    private LocalDate fechaPago;
    private Double monto;
    private String estadoPago;
    private LocalDateTime fechaCreacion;
}
