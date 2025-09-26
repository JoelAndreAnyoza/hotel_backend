package com.sise.hotel_backend.tipoHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.tipoHabitacion.application.dto.response.EliminarTipoHabitacionResponseDto;

@Component
public class EliminarTipoHabitacionMapper {
    public EliminarTipoHabitacionResponseDto entityToResponse(boolean eliminado) {

        EliminarTipoHabitacionResponseDto responseDto = new EliminarTipoHabitacionResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
