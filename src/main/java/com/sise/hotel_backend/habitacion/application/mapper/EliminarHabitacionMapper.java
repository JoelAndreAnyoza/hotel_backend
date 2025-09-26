package com.sise.hotel_backend.habitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.habitacion.application.dto.response.EliminarHabitacionResponseDto;

@Component
public class EliminarHabitacionMapper {
    public EliminarHabitacionResponseDto entityToResponse(boolean eliminado) {

        EliminarHabitacionResponseDto responseDto = new EliminarHabitacionResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
