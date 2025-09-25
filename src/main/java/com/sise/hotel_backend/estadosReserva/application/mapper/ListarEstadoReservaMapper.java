package com.sise.hotel_backend.estadosReserva.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.estadosReserva.application.dto.response.ListarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.domain.entities.EstadoReserva;

@Component
public class ListarEstadoReservaMapper {
    public ListarEstadoReservaResponseDto entityToResponse(EstadoReserva entity) {
        if (entity == null) {
            return null;
        }
        ListarEstadoReservaResponseDto responseDto = new ListarEstadoReservaResponseDto();
        responseDto.setIdEstadoReserva(entity.getIdEstadoReserva());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
