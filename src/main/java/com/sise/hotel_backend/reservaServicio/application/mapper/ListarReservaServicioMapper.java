package com.sise.hotel_backend.reservaServicio.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.reservaServicio.application.dto.response.ListarReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.domain.entities.ReservaServicio;

@Component
public class ListarReservaServicioMapper {
    public ListarReservaServicioResponseDto entityToResponse(ReservaServicio entity) {
        if (entity == null) {
            return null;
        }
        ListarReservaServicioResponseDto responseDto = new ListarReservaServicioResponseDto();
        responseDto.setIdReservaServicio(entity.getIdReservaServicio());
        responseDto.setIdReserva(entity.getIdReserva());
        responseDto.setIdServicio(entity.getIdServicio());
        responseDto.setCantidad(entity.getCantidad());
        responseDto.setSubtotal(entity.getSubtotal());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
