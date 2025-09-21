package com.sise.hotel_backend.metodoPago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.metodoPago.application.dto.request.MetodoPagoRequestDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.MetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.domain.entities.MetodoPago;

@Component
public class InsertarMetodoPagoMapper
        implements IEntityDtoMapper<MetodoPago, MetodoPagoRequestDto, MetodoPagoResponseDto> {

    @Override
    public MetodoPago requestToEntity(MetodoPagoRequestDto requestDto) {
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setNombre(requestDto.getNombre());
        metodoPago.setDescripcion(requestDto.getDescripcion());
        return metodoPago;
    }

    @Override
    public MetodoPagoResponseDto entityToResponse(MetodoPago entity) {
        MetodoPagoResponseDto responseDto = new MetodoPagoResponseDto();
        responseDto.setIdMetodoPago(entity.getIdMetodoPago());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }

}
