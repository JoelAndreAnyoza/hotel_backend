package com.sise.hotel_backend.habitacionComodidad.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.habitacionComodidad.application.dto.request.ActualizarHabitacionComodidadRequestDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.ActualizarHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.domain.entities.HabitacionComodidad;

@Component
public class ActualizarHabitacionComodidadMapper implements IEntityDtoMapper
<HabitacionComodidad, ActualizarHabitacionComodidadRequestDto, ActualizarHabitacionComodidadResponseDto>{

    @Override
    public HabitacionComodidad requestToEntity(ActualizarHabitacionComodidadRequestDto requestDto) {
        HabitacionComodidad habitacionComodidad = new HabitacionComodidad();
        habitacionComodidad.setIdHabitacion(requestDto.getIdHabitacion());
        habitacionComodidad.setIdComodidad(requestDto.getIdComodidad());
        return habitacionComodidad;
    }

    @Override
    public ActualizarHabitacionComodidadResponseDto entityToResponse(HabitacionComodidad entity) {
        ActualizarHabitacionComodidadResponseDto responseDto = 
        new ActualizarHabitacionComodidadResponseDto();
        responseDto.setIdRelacion(entity.getIdRelacion());
        responseDto.setIdHabitacion(entity.getIdHabitacion());
        responseDto.setIdComodidad(entity.getIdComodidad());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
