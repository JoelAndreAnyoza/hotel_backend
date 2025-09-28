package com.sise.hotel_backend.habitacionComodidad.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.habitacionComodidad.application.dto.request.InsertarHabitacionComodidadRequestDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.InsertarHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.domain.entities.HabitacionComodidad;

@Component
public class InsertarHabitacionComodidadMapper implements IEntityDtoMapper
<HabitacionComodidad, InsertarHabitacionComodidadRequestDto, InsertarHabitacionComodidadResponseDto> {

    @Override
    public HabitacionComodidad requestToEntity(InsertarHabitacionComodidadRequestDto requestDto) {
        HabitacionComodidad habitacionComodidad = new HabitacionComodidad();
        habitacionComodidad.setIdHabitacion(requestDto.getIdHabitacion());
        habitacionComodidad.setIdComodidad(requestDto.getIdComodidad());
        return habitacionComodidad;
    }

    @Override
    public InsertarHabitacionComodidadResponseDto entityToResponse(HabitacionComodidad entity) {
        InsertarHabitacionComodidadResponseDto responseDto = 
        new InsertarHabitacionComodidadResponseDto();
        responseDto.setIdRelacion(entity.getIdRelacion());
        responseDto.setIdHabitacion(entity.getIdHabitacion());
        responseDto.setIdComodidad(entity.getIdComodidad());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
