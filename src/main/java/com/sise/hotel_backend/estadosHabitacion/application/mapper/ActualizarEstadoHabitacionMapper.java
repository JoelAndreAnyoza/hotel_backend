package com.sise.hotel_backend.estadosHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.estadosHabitacion.application.dto.request.ActualizarEstadoHabitacionRequestDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ActualizarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.domain.entities.EstadosHabitacion;

@Component
public class ActualizarEstadoHabitacionMapper 
implements IEntityDtoMapper<EstadosHabitacion, ActualizarEstadoHabitacionRequestDto, ActualizarEstadoHabitacionResponseDto>{
    
    @Override
    public EstadosHabitacion requestToEntity(ActualizarEstadoHabitacionRequestDto requestDto) {
        EstadosHabitacion estadosHabitacion = new EstadosHabitacion();
        estadosHabitacion.setNombre(requestDto.getNombre());
        return estadosHabitacion;
    }

    @Override
    public ActualizarEstadoHabitacionResponseDto entityToResponse(EstadosHabitacion entity) {
        ActualizarEstadoHabitacionResponseDto responseDto = new ActualizarEstadoHabitacionResponseDto();
        responseDto.setIdEstadoHabitacion(entity.getIdEstadoHabitacion());
        responseDto.setNombre(entity.getNombre());
        return responseDto;
    }
}
