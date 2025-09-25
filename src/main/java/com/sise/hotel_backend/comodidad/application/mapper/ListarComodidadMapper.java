package com.sise.hotel_backend.comodidad.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.comodidad.application.dto.response.ListarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.domain.entities.Comodidad;

@Component
public class ListarComodidadMapper {
    public ListarComodidadResponseDto entityToResponse(Comodidad entity) {
        if (entity == null) {
            return null;
        }
        ListarComodidadResponseDto responseDto = new ListarComodidadResponseDto();
        responseDto.setIdComodidad(entity.getIdComodidad());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
