package com.sise.hotel_backend.metodoPago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.metodoPago.application.dto.response.ObtenerMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.domain.entities.MetodoPago;

@Component
public class ObtenerMetodoPagoMapper {
    public ObtenerMetodoPagoResponseDto entityToResponse(MetodoPago entity) {
        if (entity == null) {
            return null;
        }
        ObtenerMetodoPagoResponseDto responseDto = new ObtenerMetodoPagoResponseDto();
        responseDto.setIdMetodoPago(entity.getIdMetodoPago());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
