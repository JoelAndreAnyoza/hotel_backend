package com.sise.hotel_backend.reserva.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.reserva.application.dto.response.EliminarReservaResponseDto;

@Component
public class EliminarReservaMapper {
    public EliminarReservaResponseDto entityToResponse(boolean eliminado) {

        EliminarReservaResponseDto responseDto = new EliminarReservaResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
