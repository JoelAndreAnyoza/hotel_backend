package com.sise.hotel_backend.tipoDocumento.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ActualizarTipoDocumentoResponseDto {
    private Integer idTipoDocumento;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
}
