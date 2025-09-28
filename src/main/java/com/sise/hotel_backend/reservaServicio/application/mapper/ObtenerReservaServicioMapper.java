package com.sise.hotel_backend.reservaServicio.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.reservaServicio.application.dto.response.ObtenerReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.domain.entities.ReservaServicio;

@Component
public class ObtenerReservaServicioMapper {
    public ObtenerReservaServicioResponseDto entityToResponse(ReservaServicio entity) {
        if (entity == null) {
            return null;
        }
        ObtenerReservaServicioResponseDto responseDto = new ObtenerReservaServicioResponseDto();
        responseDto.setIdReservaServicio(entity.getIdReservaServicio());
        responseDto.setIdReserva(entity.getIdReserva());
        responseDto.setIdServicio(entity.getIdServicio());
        responseDto.setCantidad(entity.getCantidad());
        responseDto.setSubtotal(entity.getSubtotal());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
