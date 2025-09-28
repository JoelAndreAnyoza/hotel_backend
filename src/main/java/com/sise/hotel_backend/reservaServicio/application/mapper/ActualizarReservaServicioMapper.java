package com.sise.hotel_backend.reservaServicio.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.reservaServicio.application.dto.request.ActualizarReservaServicioRequestDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.ActualizarReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.domain.entities.ReservaServicio;

@Component
public class ActualizarReservaServicioMapper implements IEntityDtoMapper
<ReservaServicio, ActualizarReservaServicioRequestDto, ActualizarReservaServicioResponseDto>{
    
    @Override
    public ReservaServicio requestToEntity(ActualizarReservaServicioRequestDto requestDto) {
        ReservaServicio reservaServicio = new ReservaServicio();
        reservaServicio.setIdReserva(requestDto.getIdReserva());
        reservaServicio.setIdServicio(requestDto.getIdServicio());
        reservaServicio.setCantidad(requestDto.getCantidad());
        reservaServicio.setSubtotal(requestDto.getSubtotal());
        return reservaServicio;
    }

    @Override
    public ActualizarReservaServicioResponseDto entityToResponse(ReservaServicio entity) {
        ActualizarReservaServicioResponseDto responseDto = new ActualizarReservaServicioResponseDto();
        responseDto.setIdReservaServicio(entity.getIdReservaServicio());
        responseDto.setIdReserva(entity.getIdReserva());
        responseDto.setIdServicio(entity.getIdServicio());
        responseDto.setCantidad(entity.getCantidad());
        responseDto.setSubtotal(entity.getSubtotal());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
