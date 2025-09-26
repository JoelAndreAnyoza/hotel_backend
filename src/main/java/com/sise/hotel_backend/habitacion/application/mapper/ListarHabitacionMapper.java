package com.sise.hotel_backend.habitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.habitacion.application.dto.response.ListarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.domain.entities.Habitacion;

@Component
public class ListarHabitacionMapper {

    public ListarHabitacionResponseDto entityToResponse(Habitacion entity) {
        if (entity == null) {
            return null;
        }
        ListarHabitacionResponseDto responseDto = new ListarHabitacionResponseDto();
        responseDto.setIdHabitacion(entity.getIdHabitacion());
        responseDto.setIdTipoHabitacion(entity.getIdTipoHabitacion());
        responseDto.setIdEstadoHabitacion(entity.getIdEstadoHabitacion());
        responseDto.setNumeroHabitacion(entity.getNumeroHabitacion());
        responseDto.setPiso(entity.getPiso());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}