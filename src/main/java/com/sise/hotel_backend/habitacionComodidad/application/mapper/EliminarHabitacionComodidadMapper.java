package com.sise.hotel_backend.habitacionComodidad.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.habitacionComodidad.application.dto.response.EliminarHabitacionComodidadResponseDto;

@Component
public class EliminarHabitacionComodidadMapper {
    public EliminarHabitacionComodidadResponseDto entityToResponse(boolean eliminado) {

        EliminarHabitacionComodidadResponseDto responseDto = new EliminarHabitacionComodidadResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
