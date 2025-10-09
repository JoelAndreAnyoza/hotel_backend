package com.sise.hotel_backend.reserva.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.reserva.application.dto.request.ActualizarReservaRequestDto;
import com.sise.hotel_backend.reserva.application.dto.request.InsertarReservaRequestDto;
import com.sise.hotel_backend.reserva.application.dto.response.ActualizarReservaResponseDto;
import com.sise.hotel_backend.reserva.application.dto.response.EliminarReservaResponseDto;
import com.sise.hotel_backend.reserva.application.dto.response.InsertarReservaResponseDto;
import com.sise.hotel_backend.reserva.application.dto.response.ListarReservaResponseDto;
import com.sise.hotel_backend.reserva.application.dto.response.ObtenerReservaResponseDto;
import com.sise.hotel_backend.reserva.application.mapper.ActualizarReservaMapper;
import com.sise.hotel_backend.reserva.application.mapper.EliminarReservaMapper;
import com.sise.hotel_backend.reserva.application.mapper.InsertarReservaMapper;
import com.sise.hotel_backend.reserva.application.mapper.ListarReservaMapper;
import com.sise.hotel_backend.reserva.application.mapper.ObtenerReservaMapper;
import com.sise.hotel_backend.reserva.domain.entities.Reserva;
import com.sise.hotel_backend.reserva.domain.service.ReservaDomainService;

@Service
public class ReservaApplicationService {
    @Autowired
    ReservaDomainService reservaDomainService;

    @Autowired
    InsertarReservaMapper insertarReservaMapper;
    @Autowired
    ListarReservaMapper listarReservaMapper;
    @Autowired
    ObtenerReservaMapper obtenerReservaMapper;
    @Autowired
    ActualizarReservaMapper actualizarReservaMapper;
    @Autowired
    EliminarReservaMapper eliminarReservaMapper;

    public InsertarReservaResponseDto insertarReserva(InsertarReservaRequestDto requestDto) {
        Reserva reserva = reservaDomainService.insertarReserva(
                insertarReservaMapper.requestToEntity(requestDto));
        return insertarReservaMapper.entityToResponse(reserva);
    }

    public List<ListarReservaResponseDto> listarReserva() {
        List<Reserva> reserva = reservaDomainService.listarReserva();
        return reserva.stream().map(listarReservaMapper::entityToResponse).toList();    
    }

    public ObtenerReservaResponseDto obtenerReserva(Integer id) {
        Optional<Reserva> reserva = reservaDomainService.obtenerReserva(id);
        return reserva.stream().map(obtenerReservaMapper::entityToResponse)
                .findFirst()
                .orElse(null);    
    }

    public ActualizarReservaResponseDto actualizarReserva(Integer id, 
    ActualizarReservaRequestDto requestDto) {
        Reserva reserva = reservaDomainService.actualizarReserva(id,
                actualizarReservaMapper.requestToEntity(requestDto));
        return actualizarReservaMapper.entityToResponse(reserva);
    }

    public EliminarReservaResponseDto darBajaReserva(Integer id) {
        reservaDomainService.darBajaReserva(id);
        return eliminarReservaMapper.entityToResponse(true);    
    }
}
