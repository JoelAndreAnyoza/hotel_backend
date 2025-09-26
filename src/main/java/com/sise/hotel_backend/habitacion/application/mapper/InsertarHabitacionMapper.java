package com.sise.hotel_backend.habitacion.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.habitacion.application.dto.request.InsertarHabitacionRequestDto;
import com.sise.hotel_backend.habitacion.application.dto.response.InsertarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.domain.entities.Habitacion;

@Component
public class InsertarHabitacionMapper 
implements IEntityDtoMapper<Habitacion, InsertarHabitacionRequestDto, InsertarHabitacionResponseDto> {

    @Override
    public Habitacion requestToEntity(InsertarHabitacionRequestDto requestDto) {
        Habitacion habitacion = new Habitacion();
        habitacion.setIdTipoHabitacion(requestDto.getIdTipoHabitacion());
        habitacion.setIdEstadoHabitacion(requestDto.getIdEstadoHabitacion());
        habitacion.setNumeroHabitacion(requestDto.getNumeroHabitacion());
        habitacion.setPiso(requestDto.getPiso());
        return habitacion;
    }

    @Override
    public InsertarHabitacionResponseDto entityToResponse(Habitacion entity) {
        InsertarHabitacionResponseDto responseDto = new InsertarHabitacionResponseDto();
        responseDto.setIdHabitacion(entity.getIdHabitacion());
        responseDto.setIdTipoHabitacion(entity.getIdTipoHabitacion());
        responseDto.setIdEstadoHabitacion(entity.getIdEstadoHabitacion());
        responseDto.setNumeroHabitacion(entity.getNumeroHabitacion());
        responseDto.setPiso(entity.getPiso());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
