package com.sise.hotel_backend.pago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.pago.application.dto.request.ActualizarPagoRequestDto;
import com.sise.hotel_backend.pago.application.dto.response.ActualizarPagoResponseDto;
import com.sise.hotel_backend.pago.domain.entities.Pago;

@Component
public class ActualizarPagoMapper 
implements IEntityDtoMapper<Pago, ActualizarPagoRequestDto, ActualizarPagoResponseDto>{
    
    @Override
    public Pago requestToEntity(ActualizarPagoRequestDto requestDto) {
        Pago pago = new Pago();
        pago.setIdReserva(requestDto.getIdReserva());
        pago.setIdMetodoPago(requestDto.getIdMetodoPago());
        pago.setFechaPago(requestDto.getFechaPago());
        pago.setMonto(requestDto.getMonto());
        pago.setEstadoPago(requestDto.getEstadoPago());
        return pago;
    }

    @Override
    public ActualizarPagoResponseDto entityToResponse(Pago entity) {
        ActualizarPagoResponseDto responseDto = new ActualizarPagoResponseDto();
        responseDto.setIdPago(entity.getIdPago());
        responseDto.setIdReserva(entity.getIdReserva());
        responseDto.setIdMetodoPago(entity.getIdMetodoPago());
        responseDto.setFechaPago(entity.getFechaPago());
        responseDto.setMonto(entity.getMonto());
        responseDto.setEstadoPago(entity.getEstadoPago());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
