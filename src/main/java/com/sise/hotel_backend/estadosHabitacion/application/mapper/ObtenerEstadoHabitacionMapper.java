package com.sise.hotel_backend.estadosHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ObtenerEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.domain.entities.EstadosHabitacion;

@Component
public class ObtenerEstadoHabitacionMapper {
    
    public ObtenerEstadoHabitacionResponseDto entityToResponse(EstadosHabitacion entity) {
        if (entity == null) {
            return null;
        }
        ObtenerEstadoHabitacionResponseDto responseDto = new ObtenerEstadoHabitacionResponseDto();
        responseDto.setIdEstadoHabitacion(entity.getIdEstadoHabitacion());
        responseDto.setNombre(entity.getNombre());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
