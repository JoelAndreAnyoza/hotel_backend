package com.sise.hotel_backend.reservaServicio.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.reservaServicio.application.dto.response.EliminarReservaServicioResponseDto;

@Component
public class EliminarReservaServicioMapper {
    public EliminarReservaServicioResponseDto entityToResponse(boolean eliminado) {

        EliminarReservaServicioResponseDto responseDto = new EliminarReservaServicioResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
