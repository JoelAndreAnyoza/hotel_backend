package com.sise.hotel_backend.pago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.pago.application.dto.response.ListarPagoResponseDto;
import com.sise.hotel_backend.pago.domain.entities.Pago;

@Component
public class ListarPagoMapper {
    public ListarPagoResponseDto entityToResponse(Pago entity) {
        if (entity == null) {
            return null;
        }
        ListarPagoResponseDto responseDto = new ListarPagoResponseDto();
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
