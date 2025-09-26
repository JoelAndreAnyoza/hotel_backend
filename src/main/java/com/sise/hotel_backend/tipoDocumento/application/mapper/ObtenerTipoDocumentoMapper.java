package com.sise.hotel_backend.tipoDocumento.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.tipoDocumento.application.dto.response.ObtenerTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.domain.entities.TipoDocumento;

@Component
public class ObtenerTipoDocumentoMapper {
    public ObtenerTipoDocumentoResponseDto entityToResponse(TipoDocumento entity) {
        if (entity == null) {
            return null;
        }
        ObtenerTipoDocumentoResponseDto responseDto = new ObtenerTipoDocumentoResponseDto();
        responseDto.setIdTipoDocumento(entity.getIdTipoDocumento());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
