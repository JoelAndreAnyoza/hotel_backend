package com.sise.hotel_backend.estadosHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ListarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.domain.entities.EstadosHabitacion;

@Component
public class ListarEstadoHabitacionMapper {

    public ListarEstadoHabitacionResponseDto entityToResponse(EstadosHabitacion entity) {
        if (entity == null) {
            return null;
        }
        ListarEstadoHabitacionResponseDto responseDto = new ListarEstadoHabitacionResponseDto();
        responseDto.setIdEstadoHabitacion(entity.getIdEstadoHabitacion());
        responseDto.setNombre(entity.getNombre());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
