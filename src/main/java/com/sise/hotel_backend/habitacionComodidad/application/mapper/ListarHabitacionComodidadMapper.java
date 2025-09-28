package com.sise.hotel_backend.habitacionComodidad.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.habitacionComodidad.application.dto.response.ListarHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.domain.entities.HabitacionComodidad;

@Component
public class ListarHabitacionComodidadMapper {
    public ListarHabitacionComodidadResponseDto entityToResponse(HabitacionComodidad entity) {
        if (entity == null) {
            return null;
        }
        ListarHabitacionComodidadResponseDto responseDto = new ListarHabitacionComodidadResponseDto();
        responseDto.setIdRelacion(entity.getIdRelacion());
        responseDto.setIdHabitacion(entity.getIdHabitacion());
        responseDto.setIdComodidad(entity.getIdComodidad());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
