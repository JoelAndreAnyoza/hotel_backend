package com.sise.hotel_backend.reservaServicio.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.reservaServicio.application.dto.request.InsertarReservaServicioRequestDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.InsertarReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.domain.entities.ReservaServicio;

@Component
public class InsertarReservaServicioMapper implements IEntityDtoMapper
<ReservaServicio, InsertarReservaServicioRequestDto, InsertarReservaServicioResponseDto>{
    @Override
    public ReservaServicio requestToEntity(InsertarReservaServicioRequestDto requestDto) {
        ReservaServicio reservaServicio = new ReservaServicio();
        reservaServicio.setIdReserva(requestDto.getIdReserva());
        reservaServicio.setIdServicio(requestDto.getIdServicio());
        reservaServicio.setCantidad(requestDto.getCantidad());
        reservaServicio.setSubtotal(requestDto.getSubtotal());
        return reservaServicio;
    }

    @Override
    public InsertarReservaServicioResponseDto entityToResponse(ReservaServicio entity) {
        InsertarReservaServicioResponseDto responseDto = new InsertarReservaServicioResponseDto();
        responseDto.setIdReservaServicio(entity.getIdReservaServicio());
        responseDto.setIdReserva(entity.getIdReserva());
        responseDto.setIdServicio(entity.getIdServicio());
        responseDto.setCantidad(entity.getCantidad());
        responseDto.setSubtotal(entity.getSubtotal());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
