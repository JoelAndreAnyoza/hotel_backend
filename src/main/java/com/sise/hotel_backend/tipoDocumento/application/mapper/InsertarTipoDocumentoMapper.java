package com.sise.hotel_backend.tipoDocumento.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.tipoDocumento.application.dto.request.InsertarTipoDocumentoRequestDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.InsertarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.domain.entities.TipoDocumento;

@Component
public class InsertarTipoDocumentoMapper implements 
    IEntityDtoMapper<TipoDocumento, InsertarTipoDocumentoRequestDto, InsertarTipoDocumentoResponseDto> {

    @Override
    public TipoDocumento requestToEntity(InsertarTipoDocumentoRequestDto requestDto) {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setNombre(requestDto.getNombre());
        tipoDocumento.setDescripcion(requestDto.getDescripcion());
        return tipoDocumento;
    }

    @Override
    public InsertarTipoDocumentoResponseDto entityToResponse(TipoDocumento entity) {
        InsertarTipoDocumentoResponseDto responseDto = new InsertarTipoDocumentoResponseDto();
        responseDto.setIdTipoDocumento(entity.getIdTipoDocumento());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
