package com.sise.hotel_backend.tipoDocumento.application.dto.request;

import lombok.Data;

@Data
public class InsertarTipoDocumentoRequestDto {
    private String nombre;
    private String descripcion;
}