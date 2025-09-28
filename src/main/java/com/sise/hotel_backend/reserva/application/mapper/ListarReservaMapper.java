package com.sise.hotel_backend.reserva.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.reserva.application.dto.response.ListarReservaResponseDto;
import com.sise.hotel_backend.reserva.domain.entities.Reserva;

@Component
public class ListarReservaMapper {
    public ListarReservaResponseDto entityToResponse(Reserva entity) {
        if (entity == null) {
            return null;
        }
        ListarReservaResponseDto responseDto = new ListarReservaResponseDto();
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
