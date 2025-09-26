package com.sise.hotel_backend.metodoPago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.metodoPago.application.dto.response.ListarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.domain.entities.MetodoPago;

@Component
public class ListarMetodoPagoMapper {
    public ListarMetodoPagoResponseDto entityToResponse(MetodoPago entity) {
        if (entity == null) {
            return null;
        }
        ListarMetodoPagoResponseDto responseDto = new ListarMetodoPagoResponseDto();
        responseDto.setIdMetodoPago(entity.getIdMetodoPago());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
