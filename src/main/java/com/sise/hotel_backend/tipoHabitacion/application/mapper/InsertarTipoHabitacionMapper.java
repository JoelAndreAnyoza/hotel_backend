package com.sise.hotel_backend.tipoHabitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.tipoHabitacion.application.dto.request.InsertarTipoHabitacionRequestDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.InsertarTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.domain.entities.TipoHabitacion;

@Component
public class InsertarTipoHabitacionMapper 
    implements IEntityDtoMapper<TipoHabitacion, InsertarTipoHabitacionRequestDto, InsertarTipoHabitacionResponseDto> {

    @Override 
    public TipoHabitacion requestToEntity(InsertarTipoHabitacionRequestDto requestDto) {
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setNombre(requestDto.getNombre());
        tipoHabitacion.setDescripcion(requestDto.getDescripcion());
        tipoHabitacion.setCapacidad(requestDto.getCapacidad());
        tipoHabitacion.setPrecioBase(requestDto.getPrecioBase());
        return tipoHabitacion;
    }

    @Override
    public InsertarTipoHabitacionResponseDto entityToResponse(TipoHabitacion entity) {
        InsertarTipoHabitacionResponseDto responseDto = new InsertarTipoHabitacionResponseDto();
        responseDto.setIdTipoHabitacion(entity.getIdTipoHabitacion());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setCapacidad(entity.getCapacidad());
        responseDto.setPrecioBase(entity.getPrecioBase());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
    
}
