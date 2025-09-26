package com.sise.hotel_backend.tipoHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.tipoHabitacion.application.dto.request.ActualizarTipoHabitacionRequestDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.ActualizarTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.domain.entities.TipoHabitacion;

@Component
public class ActualizarTipoHabitacionMapper 
implements IEntityDtoMapper<TipoHabitacion, ActualizarTipoHabitacionRequestDto, ActualizarTipoHabitacionResponseDto>{
    @Override
    public TipoHabitacion requestToEntity(ActualizarTipoHabitacionRequestDto requestDto) {
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setNombre(requestDto.getNombre());
        tipoHabitacion.setDescripcion(requestDto.getDescripcion());
        tipoHabitacion.setCapacidad(requestDto.getCapacidad());
        tipoHabitacion.setPrecioBase(requestDto.getPrecioBase());
        return tipoHabitacion;
    }

    @Override
    public ActualizarTipoHabitacionResponseDto entityToResponse(TipoHabitacion entity) {
        ActualizarTipoHabitacionResponseDto responseDto = new ActualizarTipoHabitacionResponseDto();
        responseDto.setIdTipoHabitacion(entity.getIdTipoHabitacion());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setCapacidad(entity.getCapacidad());
        responseDto.setPrecioBase(entity.getPrecioBase());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
