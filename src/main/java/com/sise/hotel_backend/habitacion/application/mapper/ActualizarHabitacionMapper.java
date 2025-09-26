package com.sise.hotel_backend.habitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.habitacion.application.dto.request.ActualizarHabitacionRequestDto;
import com.sise.hotel_backend.habitacion.application.dto.response.ActualizarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.domain.entities.Habitacion;

@Component
public class ActualizarHabitacionMapper 
implements IEntityDtoMapper<Habitacion,ActualizarHabitacionRequestDto,ActualizarHabitacionResponseDto>{
    
    @Override
    public Habitacion requestToEntity(ActualizarHabitacionRequestDto requestDto) {
        Habitacion habitacion = new Habitacion();
        habitacion.setIdTipoHabitacion(requestDto.getIdTipoHabitacion());
        habitacion.setIdEstadoHabitacion(requestDto.getIdEstadoHabitacion());
        habitacion.setNumeroHabitacion(requestDto.getNumeroHabitacion());
        habitacion.setPiso(requestDto.getPiso());
        return habitacion;
    }

    @Override
    public ActualizarHabitacionResponseDto entityToResponse(Habitacion entity) {
        ActualizarHabitacionResponseDto responseDto = new ActualizarHabitacionResponseDto();
        responseDto.setIdHabitacion(entity.getIdHabitacion());
        responseDto.setIdTipoHabitacion(entity.getIdTipoHabitacion());
        responseDto.setIdEstadoHabitacion(entity.getIdEstadoHabitacion());
        responseDto.setNumeroHabitacion(entity.getNumeroHabitacion());
        responseDto.setPiso(entity.getPiso());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
