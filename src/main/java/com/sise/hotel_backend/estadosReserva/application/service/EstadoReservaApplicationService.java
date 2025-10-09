package com.sise.hotel_backend.estadosReserva.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.estadosReserva.application.dto.request.ActualizarEstadoReservaRequestDto;
import com.sise.hotel_backend.estadosReserva.application.dto.request.InsertarEstadoReservaRequestDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.ActualizarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.EliminarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.InsertarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.ListarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.ObtenerEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.mapper.ActualizarEstadoReservaMapper;
import com.sise.hotel_backend.estadosReserva.application.mapper.EliminarEstadoReservaMapper;
import com.sise.hotel_backend.estadosReserva.application.mapper.InsertarEstadoReservaMapper;
import com.sise.hotel_backend.estadosReserva.application.mapper.ListarEstadoReservaMapper;
import com.sise.hotel_backend.estadosReserva.application.mapper.ObtenerEstadoReservaMapper;
import com.sise.hotel_backend.estadosReserva.domain.entities.EstadoReserva;
import com.sise.hotel_backend.estadosReserva.domain.service.EstadoReservaDomainService;

@Service
public class EstadoReservaApplicationService {

    @Autowired
    EstadoReservaDomainService estadoReservaDomainService;

    @Autowired
    InsertarEstadoReservaMapper insertarEstadoReservaMapper;
    @Autowired
    ListarEstadoReservaMapper listarEstadoReservaMapper;
    @Autowired
    ObtenerEstadoReservaMapper obtenerEstadoReservaMapper;
    @Autowired
    ActualizarEstadoReservaMapper actualizarEstadoReservaMapper;
    @Autowired
    EliminarEstadoReservaMapper eliminarEstadoReservaMapper;

    public InsertarEstadoReservaResponseDto insertarEstadoReserva(InsertarEstadoReservaRequestDto requestDto) {
        EstadoReserva estadoReserva = estadoReservaDomainService.insertarEstadoReserva(
                insertarEstadoReservaMapper.requestToEntity(requestDto));
        return insertarEstadoReservaMapper.entityToResponse(estadoReserva);
    }

    public List<ListarEstadoReservaResponseDto> listarEstadoReserva() {
        List<EstadoReserva> estadoReserva = estadoReservaDomainService.listarEstadoReservas();
        return estadoReserva.stream()
                .map(listarEstadoReservaMapper::entityToResponse)
                .toList();
    }

    public ObtenerEstadoReservaResponseDto obtenerEstadoReservaPorId(Integer id) {
        Optional<EstadoReserva> estadoReserva = estadoReservaDomainService.obtenerEstadoReserva(id);
        return estadoReserva.stream()
                .map(obtenerEstadoReservaMapper::entityToResponse)
                .findFirst()
                .orElse(null);
    }

    public ActualizarEstadoReservaResponseDto actualizarEstadoReserva(Integer id, 
    ActualizarEstadoReservaRequestDto requestDto) {
        EstadoReserva estadoReserva = estadoReservaDomainService.actualizarEstadoReserva(id,
                actualizarEstadoReservaMapper.requestToEntity(requestDto));
        return actualizarEstadoReservaMapper.entityToResponse(estadoReserva);
    }

    public EliminarEstadoReservaResponseDto darBajaEstadoReserva(Integer id) {
        estadoReservaDomainService.darBajaEstadoReserva(id);
        return eliminarEstadoReservaMapper.entityToResponse(true);
    }
}
