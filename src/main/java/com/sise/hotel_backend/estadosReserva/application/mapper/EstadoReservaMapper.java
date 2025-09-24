package com.sise.hotel_backend.estadosReserva.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.estadosReserva.application.dto.request.EstadoReservaRequestDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.EstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.domain.entities.EstadoReserva;

@Component
public class EstadoReservaMapper 
implements IEntityDtoMapper<EstadoReserva, EstadoReservaRequestDto, EstadoReservaResponseDto> {
    
    @Override
    public EstadoReserva requestToEntity(EstadoReservaRequestDto requestDto) {
        EstadoReserva estadoReserva = new EstadoReserva();
        estadoReserva.setNombre(requestDto.getNombre());
        estadoReserva.setDescripcion(requestDto.getDescripcion());
        return estadoReserva;
    }

    @Override
    public EstadoReservaResponseDto entityToResponse(EstadoReserva entity) {
        EstadoReservaResponseDto responseDto = new EstadoReservaResponseDto();
        responseDto.setIdEstadoReserva(entity.getIdEstadoReserva());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
