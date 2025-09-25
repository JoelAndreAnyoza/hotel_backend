package com.sise.hotel_backend.estadosHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.estadosHabitacion.application.dto.request.InsertarEstadoHabitacionRequestDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.InsertarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.domain.entities.EstadosHabitacion;

@Component
public class InsertarEstadoHabitacionMapper 
    implements IEntityDtoMapper<EstadosHabitacion, InsertarEstadoHabitacionRequestDto, InsertarEstadoHabitacionResponseDto>{
    
    @Override
    public EstadosHabitacion requestToEntity(InsertarEstadoHabitacionRequestDto requestDto) {
        EstadosHabitacion estadosHabitacion = new EstadosHabitacion();
        estadosHabitacion.setNombre(requestDto.getNombre());
        return estadosHabitacion;
    }

    @Override
    public InsertarEstadoHabitacionResponseDto entityToResponse(EstadosHabitacion entity) {
        InsertarEstadoHabitacionResponseDto responseDto = new InsertarEstadoHabitacionResponseDto();
        responseDto.setIdEstadoHabitacion(entity.getIdEstadoHabitacion());
        responseDto.setNombre(entity.getNombre());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
