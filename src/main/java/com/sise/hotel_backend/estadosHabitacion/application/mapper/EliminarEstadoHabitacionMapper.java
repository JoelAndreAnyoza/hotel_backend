package com.sise.hotel_backend.estadosHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.estadosHabitacion.application.dto.response.EliminarEstadoHabitacionResponseDto;

@Component
public class EliminarEstadoHabitacionMapper {
    
    public EliminarEstadoHabitacionResponseDto entityToResponse(boolean eliminado) {

        EliminarEstadoHabitacionResponseDto responseDto = new EliminarEstadoHabitacionResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}

