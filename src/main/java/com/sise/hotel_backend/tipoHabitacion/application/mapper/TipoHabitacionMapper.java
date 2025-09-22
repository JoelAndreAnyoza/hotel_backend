package com.sise.hotel_backend.tipoHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.tipoHabitacion.application.dto.request.TipoHabitacionRequestDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.TipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.domain.entities.TipoHabitacion;

@Component
public class TipoHabitacionMapper 
    implements IEntityDtoMapper<TipoHabitacion, TipoHabitacionRequestDto, TipoHabitacionResponseDto> {

    @Override 
    public TipoHabitacion requestToEntity(TipoHabitacionRequestDto requestDto) {
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setNombre(requestDto.getNombre());
        tipoHabitacion.setDescripcion(requestDto.getDescripcion());
        tipoHabitacion.setCapacidad(requestDto.getCapacidad());
        tipoHabitacion.setPrecioBase(requestDto.getPrecioBase());
        return tipoHabitacion;
    }

    @Override
    public TipoHabitacionResponseDto entityToResponse(TipoHabitacion entity) {
        TipoHabitacionResponseDto responseDto = new TipoHabitacionResponseDto();
        responseDto.setIdTipoHabitacion(entity.getIdTipoHabitacion());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setCapacidad(entity.getCapacidad());
        responseDto.setPrecioBase(entity.getPrecioBase());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
    
}
