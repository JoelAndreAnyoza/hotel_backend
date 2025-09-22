package com.sise.hotel_backend.comodidad.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.comodidad.application.dto.request.ComodidadRequestDto;
import com.sise.hotel_backend.comodidad.application.dto.response.ComodidadResponseDto;
import com.sise.hotel_backend.comodidad.domain.entities.Comodidad;

@Component
public class ComodidadMapper implements IEntityDtoMapper<Comodidad, ComodidadRequestDto, ComodidadResponseDto> {

    @Override
    public Comodidad requestToEntity(ComodidadRequestDto requestDto) {
        Comodidad comodidad = new Comodidad();
        comodidad.setNombre(requestDto.getNombre());
        comodidad.setDescripcion(requestDto.getDescripcion());
        return comodidad;
    }

    @Override
    public ComodidadResponseDto entityToResponse(Comodidad entity) {
        ComodidadResponseDto responseDto = new ComodidadResponseDto();
        responseDto.setIdComodidad(entity.getIdComodidad());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }

}
