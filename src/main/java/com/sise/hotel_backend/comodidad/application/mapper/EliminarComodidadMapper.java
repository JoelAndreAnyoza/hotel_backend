package com.sise.hotel_backend.comodidad.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.comodidad.application.dto.response.EliminarComodidadResponseDto;

@Component
public class EliminarComodidadMapper {

    public EliminarComodidadResponseDto entityToResponse(boolean eliminado) {

        EliminarComodidadResponseDto responseDto = new EliminarComodidadResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
