package com.sise.hotel_backend.estadosReserva.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.estadosReserva.application.dto.request.InsertarEstadoReservaRequestDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.InsertarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.domain.entities.EstadoReserva;

@Component
public class InsertarEstadoReservaMapper 
implements IEntityDtoMapper<EstadoReserva, InsertarEstadoReservaRequestDto, InsertarEstadoReservaResponseDto> {
    
    @Override
    public EstadoReserva requestToEntity(InsertarEstadoReservaRequestDto requestDto) {
        EstadoReserva estadoReserva = new EstadoReserva();
        estadoReserva.setNombre(requestDto.getNombre());
        estadoReserva.setDescripcion(requestDto.getDescripcion());
        return estadoReserva;
    }

    @Override
    public InsertarEstadoReservaResponseDto entityToResponse(EstadoReserva entity) {
        InsertarEstadoReservaResponseDto responseDto = new InsertarEstadoReservaResponseDto();
        responseDto.setIdEstadoReserva(entity.getIdEstadoReserva());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
