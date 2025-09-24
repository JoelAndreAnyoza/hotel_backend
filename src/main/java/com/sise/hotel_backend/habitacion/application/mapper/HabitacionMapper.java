package com.sise.hotel_backend.habitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.habitacion.application.dto.request.HabitacionRequestDto;
import com.sise.hotel_backend.habitacion.application.dto.response.HabitacionResponseDto;
import com.sise.hotel_backend.habitacion.domain.entities.Habitacion;

@Component
public class HabitacionMapper 
implements IEntityDtoMapper<Habitacion, HabitacionRequestDto, HabitacionResponseDto> {

    @Override
    public Habitacion requestToEntity(HabitacionRequestDto requestDto) {
        Habitacion habitacion = new Habitacion();
        habitacion.setIdTipoHabitacion(requestDto.getIdTipoHabitacion());
        habitacion.setIdEstadoHabitacion(requestDto.getIdEstadoHabitacion());
        habitacion.setNumeroHabitacion(requestDto.getNumeroHabitacion());
        habitacion.setPiso(requestDto.getPiso());
        return habitacion;
    }

    @Override
    public HabitacionResponseDto entityToResponse(Habitacion entity) {
        HabitacionResponseDto responseDto = new HabitacionResponseDto();
        responseDto.setIdHabitacion(entity.getIdHabitacion());
        responseDto.setIdTipoHabitacion(entity.getIdTipoHabitacion());
        responseDto.setIdEstadoHabitacion(entity.getIdEstadoHabitacion());
        responseDto.setNumeroHabitacion(entity.getNumeroHabitacion());
        responseDto.setPiso(entity.getPiso());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
