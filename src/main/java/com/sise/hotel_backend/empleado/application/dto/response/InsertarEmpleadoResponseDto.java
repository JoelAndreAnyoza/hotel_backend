package com.sise.hotel_backend.empleado.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class InsertarEmpleadoResponseDto {
    private Integer idEmpleado;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String cargo;
    private LocalDateTime fechaCreacion;
}
