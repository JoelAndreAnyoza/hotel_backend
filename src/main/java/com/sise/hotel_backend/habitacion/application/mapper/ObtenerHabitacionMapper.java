package com.sise.hotel_backend.habitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.habitacion.application.dto.response.ObtenerHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.domain.entities.Habitacion;

@Component
public class ObtenerHabitacionMapper {
    public ObtenerHabitacionResponseDto entityToResponse(Habitacion entity) {
        if (entity == null) {
            return null;
        }
        ObtenerHabitacionResponseDto responseDto = new ObtenerHabitacionResponseDto();
        responseDto.setIdHabitacion(entity.getIdHabitacion());
        responseDto.setIdTipoHabitacion(entity.getIdTipoHabitacion());
        responseDto.setIdEstadoHabitacion(entity.getIdEstadoHabitacion());
        responseDto.setNumeroHabitacion(entity.getNumeroHabitacion());
        responseDto.setPiso(entity.getPiso());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
