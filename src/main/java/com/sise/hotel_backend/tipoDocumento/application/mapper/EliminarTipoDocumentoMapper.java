package com.sise.hotel_backend.tipoDocumento.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.tipoDocumento.application.dto.response.EliminarTipoDocumentoResponseDto;

@Component
public class EliminarTipoDocumentoMapper {
    public EliminarTipoDocumentoResponseDto entityToResponse(boolean eliminado) {

        EliminarTipoDocumentoResponseDto responseDto = new EliminarTipoDocumentoResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
