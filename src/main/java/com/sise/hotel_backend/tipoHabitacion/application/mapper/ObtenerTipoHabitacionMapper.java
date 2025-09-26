package com.sise.hotel_backend.tipoHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.tipoHabitacion.application.dto.response.ObtenerTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.domain.entities.TipoHabitacion;

@Component
public class ObtenerTipoHabitacionMapper {
    public ObtenerTipoHabitacionResponseDto entityToResponse(TipoHabitacion entity) {
        if (entity == null) {
            return null;
        }
        ObtenerTipoHabitacionResponseDto responseDto = new ObtenerTipoHabitacionResponseDto();
        responseDto.setIdTipoHabitacion(entity.getIdTipoHabitacion());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setCapacidad(entity.getCapacidad());
        responseDto.setPrecioBase(entity.getPrecioBase());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
