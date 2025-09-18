package com.sise.hotel_backend.empleado.application.dto.request;

import lombok.Data;

@Data
public class InsertarEmpleadoRequestDto {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String cargo;
    
}
