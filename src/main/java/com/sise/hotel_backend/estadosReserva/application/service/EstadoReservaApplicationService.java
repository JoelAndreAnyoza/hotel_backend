package com.sise.hotel_backend.estadosReserva.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.estadosReserva.application.dto.request.EstadoReservaRequestDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.EstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.mapper.EstadoReservaMapper;
import com.sise.hotel_backend.estadosReserva.domain.entities.EstadoReserva;
import com.sise.hotel_backend.estadosReserva.domain.service.EstadoReservaDomainService;

@Service
public class EstadoReservaApplicationService {

    @Autowired
    EstadoReservaDomainService estadoReservaDomainService;

    @Autowired
    EstadoReservaMapper estadoReservaMapper;

    public EstadoReservaResponseDto insertarEstadoReserva(EstadoReservaRequestDto requestDto) {
        EstadoReserva estadoReserva = estadoReservaDomainService.insertarEstadoReserva(
                estadoReservaMapper.requestToEntity(requestDto));
        return estadoReservaMapper.entityToResponse(estadoReserva);
    }

    public List<EstadoReserva> listarEstadoReserva() {
        return estadoReservaDomainService.listarEstadoReservas();
    }

    public Optional<EstadoReserva> obtenerEstadoReservaPorId(Integer id) {
        return estadoReservaDomainService.obtenerEstadoReserva(id);
    }

    public EstadoReserva actualizarEstadoReserva(EstadoReserva estadoReserva) {
        return estadoReservaDomainService.actualizarEstadoReserva(estadoReserva);
    }

    public boolean eliminarEstadoReserva(Integer id) {
        return estadoReservaDomainService.eliminarEstadoReserva(id);
    }
}
