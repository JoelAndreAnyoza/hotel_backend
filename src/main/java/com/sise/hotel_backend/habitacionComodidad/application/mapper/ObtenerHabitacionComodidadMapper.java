package com.sise.hotel_backend.habitacionComodidad.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.habitacionComodidad.application.dto.response.ObtenerHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.domain.entities.HabitacionComodidad;

@Component
public class ObtenerHabitacionComodidadMapper {
    public ObtenerHabitacionComodidadResponseDto entityToResponse(HabitacionComodidad entity) {
        if (entity == null) {
            return null;
        }
        ObtenerHabitacionComodidadResponseDto responseDto = new ObtenerHabitacionComodidadResponseDto();
        responseDto.setIdRelacion(entity.getIdRelacion());
        responseDto.setIdHabitacion(entity.getIdHabitacion());
        responseDto.setIdComodidad(entity.getIdComodidad());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
