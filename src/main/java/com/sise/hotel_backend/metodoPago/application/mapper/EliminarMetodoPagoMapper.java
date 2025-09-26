package com.sise.hotel_backend.metodoPago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.metodoPago.application.dto.response.EliminarMetodoPagoResponseDto;

@Component
public class EliminarMetodoPagoMapper {
    public EliminarMetodoPagoResponseDto entityToResponse(boolean eliminado) {

        EliminarMetodoPagoResponseDto responseDto = new EliminarMetodoPagoResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
