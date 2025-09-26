package com.sise.hotel_backend.tipoDocumento.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.tipoDocumento.application.dto.request.ActualizarTipoDocumentoRequestDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.ActualizarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.domain.entities.TipoDocumento;

@Component
public class ActualizarTipoDocumentoMapper 
implements IEntityDtoMapper<TipoDocumento, ActualizarTipoDocumentoRequestDto, ActualizarTipoDocumentoResponseDto>{

    @Override
    public TipoDocumento requestToEntity(ActualizarTipoDocumentoRequestDto requestDto) {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setNombre(requestDto.getNombre());
        tipoDocumento.setDescripcion(requestDto.getDescripcion());
        return tipoDocumento;
    }

    @Override
    public ActualizarTipoDocumentoResponseDto entityToResponse(TipoDocumento entity) {
        ActualizarTipoDocumentoResponseDto responseDto = new ActualizarTipoDocumentoResponseDto();
        responseDto.setIdTipoDocumento(entity.getIdTipoDocumento());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
