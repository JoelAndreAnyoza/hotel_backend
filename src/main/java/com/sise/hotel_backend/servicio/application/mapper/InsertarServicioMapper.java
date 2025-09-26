package com.sise.hotel_backend.servicio.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.servicio.application.dto.response.InsertarServicioResponseDto;
import com.sise.hotel_backend.servicio.domain.entities.Servicio;
import com.sise.hotel_backend.servicio.application.dto.request.InsertarServicioRequestDto;

@Component
public class InsertarServicioMapper implements IEntityDtoMapper<Servicio, InsertarServicioRequestDto, InsertarServicioResponseDto> {

    @Override
    public Servicio requestToEntity(InsertarServicioRequestDto requestDto) {
        Servicio servicio = new Servicio();
        servicio.setNombre(requestDto.getNombre());
        servicio.setDescripcion(requestDto.getDescripcion());
        servicio.setPrecio(requestDto.getPrecio());
        return servicio;
    }

    @Override
    public InsertarServicioResponseDto entityToResponse(Servicio entity) {
        InsertarServicioResponseDto responseDto = new InsertarServicioResponseDto();
        responseDto.setIdServicio(entity.getIdServicio());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setPrecio(entity.getPrecio());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}