package com.sise.hotel_backend.servicio.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.servicio.application.dto.response.ObtenerServicioResponseDto;
import com.sise.hotel_backend.servicio.domain.entities.Servicio;

@Component
public class ObtenerServicioMapper {
    public ObtenerServicioResponseDto entityToResponse(Servicio entity) {
        if (entity == null) {
            return null;
        }
        ObtenerServicioResponseDto responseDto = new ObtenerServicioResponseDto();
        responseDto.setIdServicio(entity.getIdServicio());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setPrecio(entity.getPrecio());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
