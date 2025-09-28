package com.sise.hotel_backend.pago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.pago.application.dto.response.EliminarPagoResponseDto;

@Component
public class EliminarPagoMapper {
    public EliminarPagoResponseDto entityToResponse(boolean eliminado) {

        EliminarPagoResponseDto responseDto = new EliminarPagoResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
