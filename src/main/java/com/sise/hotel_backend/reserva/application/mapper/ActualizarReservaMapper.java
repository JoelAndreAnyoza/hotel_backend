package com.sise.hotel_backend.reserva.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.reserva.application.dto.request.ActualizarReservaRequestDto;
import com.sise.hotel_backend.reserva.application.dto.response.ActualizarReservaResponseDto;
import com.sise.hotel_backend.reserva.domain.entities.Reserva;

@Component
public class ActualizarReservaMapper implements IEntityDtoMapper
<Reserva, ActualizarReservaRequestDto, ActualizarReservaResponseDto>{
    
    @Override
    public Reserva requestToEntity(ActualizarReservaRequestDto requestDto) {
        Reserva reserva = new Reserva();
        reserva.setIdUsuario(requestDto.getIdUsuario());
        reserva.setIdHabitacion(requestDto.getIdHabitacion());
        reserva.setIdEstadoReserva(requestDto.getIdEstadoReserva());
        reserva.setFechaIngreso(requestDto.getFechaIngreso());
        reserva.setFechaSalida(requestDto.getFechaSalida());
        reserva.setNumeroPersonas(requestDto.getNumeroPersonas());
        reserva.setMontoTotal(requestDto.getMontoTotal());
        reserva.setObservaciones(requestDto.getObservaciones());
        return reserva;
    }

    @Override
    public ActualizarReservaResponseDto entityToResponse(Reserva entity) {
        ActualizarReservaResponseDto responseDto = new ActualizarReservaResponseDto();
        responseDto.setIdReserva(entity.getIdReserva());
        responseDto.setIdUsuario(entity.getIdUsuario());
        responseDto.setIdHabitacion(entity.getIdHabitacion());
        responseDto.setIdEstadoReserva(entity.getIdEstadoReserva());
        responseDto.setFechaReserva(entity.getFechaReserva());
        responseDto.setFechaIngreso(entity.getFechaIngreso());
        responseDto.setFechaSalida(entity.getFechaSalida());
        responseDto.setNumeroPersonas(entity.getNumeroPersonas());
        responseDto.setCodigoConfirmacion(entity.getCodigoConfirmacion());
        responseDto.setMontoTotal(entity.getMontoTotal());
        responseDto.setObservaciones(entity.getObservaciones());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
