package com.sise.hotel_backend.metodoPago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.metodoPago.application.dto.request.ActualizarMetodoPagoRequestDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.ActualizarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.domain.entities.MetodoPago;

@Component
public class ActualizarMetodoPagoMapper 
implements IEntityDtoMapper<MetodoPago,ActualizarMetodoPagoRequestDto, ActualizarMetodoPagoResponseDto>{

    @Override
    public MetodoPago requestToEntity(ActualizarMetodoPagoRequestDto requestDto) {
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setNombre(requestDto.getNombre());
        metodoPago.setDescripcion(requestDto.getDescripcion());
        return metodoPago;
    }

    @Override
    public ActualizarMetodoPagoResponseDto entityToResponse(MetodoPago entity) {
        ActualizarMetodoPagoResponseDto responseDto = new ActualizarMetodoPagoResponseDto();
        responseDto.setIdMetodoPago(entity.getIdMetodoPago());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
