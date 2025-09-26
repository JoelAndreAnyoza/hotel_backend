package com.sise.hotel_backend.tipoHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.tipoHabitacion.application.dto.response.ListarTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.domain.entities.TipoHabitacion;

@Component
public class ListarTipoHabitacionMapper {
    public ListarTipoHabitacionResponseDto entityToResponse(TipoHabitacion entity) {
        if (entity == null) {
            return null;
        }
        ListarTipoHabitacionResponseDto responseDto = new ListarTipoHabitacionResponseDto();
        responseDto.setIdTipoHabitacion(entity.getIdTipoHabitacion());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setCapacidad(entity.getCapacidad());
        responseDto.setPrecioBase(entity.getPrecioBase());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
