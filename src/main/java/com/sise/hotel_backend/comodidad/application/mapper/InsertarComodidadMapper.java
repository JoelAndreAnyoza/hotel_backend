package com.sise.hotel_backend.comodidad.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.comodidad.application.dto.request.InsertarComodidadRequestDto;
import com.sise.hotel_backend.comodidad.application.dto.response.InsertarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.domain.entities.Comodidad;

@Component
public class InsertarComodidadMapper 
implements IEntityDtoMapper<Comodidad, InsertarComodidadRequestDto, InsertarComodidadResponseDto> {

    @Override
    public Comodidad requestToEntity(InsertarComodidadRequestDto requestDto) {
        Comodidad comodidad = new Comodidad();
        comodidad.setNombre(requestDto.getNombre());
        comodidad.setDescripcion(requestDto.getDescripcion());
        return comodidad;
    }

    @Override
    public InsertarComodidadResponseDto entityToResponse(Comodidad entity) {
        InsertarComodidadResponseDto responseDto = new InsertarComodidadResponseDto();
        responseDto.setIdComodidad(entity.getIdComodidad());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }

}
