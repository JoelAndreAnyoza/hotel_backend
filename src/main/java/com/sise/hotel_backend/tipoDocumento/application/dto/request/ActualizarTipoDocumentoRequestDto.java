package com.sise.hotel_backend.tipoDocumento.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ActualizarTipoDocumentoRequestDto {
    @NotBlank
    @Size(min = 1, max = 50)
    private String nombre;
    private String descripcion;
}
