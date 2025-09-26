package com.sise.hotel_backend.servicio.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.servicio.application.dto.response.EliminarServicioResponseDto;

@Component
public class EliminarServicioMapper {
    public EliminarServicioResponseDto entityToResponse(boolean eliminado) {

        EliminarServicioResponseDto responseDto = new EliminarServicioResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
