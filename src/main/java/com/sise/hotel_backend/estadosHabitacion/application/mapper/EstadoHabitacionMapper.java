package com.sise.hotel_backend.estadosHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.estadosHabitacion.application.dto.request.EstadoHabitacionRequestDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.EstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.domain.entities.EstadosHabitacion;

@Component
public class EstadoHabitacionMapper 
    implements IEntityDtoMapper<EstadosHabitacion, EstadoHabitacionRequestDto, EstadoHabitacionResponseDto>{
    
    @Override
    public EstadosHabitacion requestToEntity(EstadoHabitacionRequestDto requestDto) {
        EstadosHabitacion estadosHabitacion = new EstadosHabitacion();
        estadosHabitacion.setNombre(requestDto.getNombre());
        return estadosHabitacion;
    }

    @Override
    public EstadoHabitacionResponseDto entityToResponse(EstadosHabitacion entity) {
        EstadoHabitacionResponseDto responseDto = new EstadoHabitacionResponseDto();
        responseDto.setIdEstadoHabitacion(entity.getIdEstadoHabitacion());
        responseDto.setNombre(entity.getNombre());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
