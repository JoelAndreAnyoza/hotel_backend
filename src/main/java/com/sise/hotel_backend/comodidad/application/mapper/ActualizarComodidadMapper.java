package com.sise.hotel_backend.comodidad.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.comodidad.application.dto.request.ActualizarComodidadRequestDto;
import com.sise.hotel_backend.comodidad.application.dto.response.ActualizarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.domain.entities.Comodidad;

@Component
public class ActualizarComodidadMapper 
implements IEntityDtoMapper<Comodidad,ActualizarComodidadRequestDto,ActualizarComodidadResponseDto>{
    
    @Override
    public Comodidad requestToEntity(ActualizarComodidadRequestDto requestDto) {
        Comodidad comodidad = new Comodidad();
        comodidad.setNombre(requestDto.getNombre());
        comodidad.setDescripcion(requestDto.getDescripcion());
        return comodidad;
    }

    @Override
    public ActualizarComodidadResponseDto entityToResponse(Comodidad entity) {
        ActualizarComodidadResponseDto responseDto = new ActualizarComodidadResponseDto();
        responseDto.setIdComodidad(entity.getIdComodidad());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
