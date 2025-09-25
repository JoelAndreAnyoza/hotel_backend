package com.sise.hotel_backend.estadosReserva.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.estadosReserva.application.dto.response.EliminarEstadoReservaResponseDto;

@Component
public class EliminarEstadoReservaMapper {
    public EliminarEstadoReservaResponseDto entityToResponse(boolean eliminado) {

        EliminarEstadoReservaResponseDto responseDto = new EliminarEstadoReservaResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
