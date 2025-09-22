package com.sise.hotel_backend.servicio.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.servicio.application.dto.response.ServicioResponseDto;
import com.sise.hotel_backend.servicio.domain.entities.Servicio;
import com.sise.hotel_backend.servicio.application.dto.request.ServicioRequestDto;

@Component
public class ServicioMapper implements IEntityDtoMapper<Servicio, ServicioRequestDto, ServicioResponseDto> {

    @Override
    public Servicio requestToEntity(ServicioRequestDto requestDto) {
        Servicio servicio = new Servicio();
        servicio.setNombre(requestDto.getNombre());
        servicio.setDescripcion(requestDto.getDescripcion());
        servicio.setPrecio(requestDto.getPrecio());
        return servicio;
    }

    @Override
    public ServicioResponseDto entityToResponse(Servicio entity) {
        ServicioResponseDto responseDto = new ServicioResponseDto();
        responseDto.setIdServicio(entity.getIdServicio());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setPrecio(entity.getPrecio());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}