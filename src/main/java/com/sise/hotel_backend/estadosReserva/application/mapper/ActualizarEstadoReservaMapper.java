package com.sise.hotel_backend.estadosReserva.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.estadosReserva.application.dto.request.ActualizarEstadoReservaRequestDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.ActualizarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.domain.entities.EstadoReserva;

@Component
public class ActualizarEstadoReservaMapper 
implements IEntityDtoMapper<EstadoReserva,ActualizarEstadoReservaRequestDto, ActualizarEstadoReservaResponseDto>{

    @Override
    public EstadoReserva requestToEntity(ActualizarEstadoReservaRequestDto requestDto) {
        EstadoReserva estadoReserva = new EstadoReserva();
        estadoReserva.setNombre(requestDto.getNombre());
        estadoReserva.setDescripcion(requestDto.getDescripcion());
        return estadoReserva;
    }

    @Override
    public ActualizarEstadoReservaResponseDto entityToResponse(EstadoReserva entity) {
        ActualizarEstadoReservaResponseDto responseDto = new ActualizarEstadoReservaResponseDto();
        responseDto.setIdEstadoReserva(entity.getIdEstadoReserva());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
