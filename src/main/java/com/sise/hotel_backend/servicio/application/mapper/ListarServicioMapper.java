package com.sise.hotel_backend.servicio.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.servicio.application.dto.response.ListarServicioResponseDto;
import com.sise.hotel_backend.servicio.domain.entities.Servicio;

@Component
public class ListarServicioMapper {
    public ListarServicioResponseDto entityToResponse(Servicio entity) {
        if (entity == null) {
            return null;
        }
        ListarServicioResponseDto responseDto = new ListarServicioResponseDto();
        responseDto.setIdServicio(entity.getIdServicio());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setPrecio(entity.getPrecio());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
