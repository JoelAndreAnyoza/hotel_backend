package com.sise.hotel_backend.reservaServicio.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.reservaServicio.application.dto.request.ActualizarReservaServicioRequestDto;
import com.sise.hotel_backend.reservaServicio.application.dto.request.InsertarReservaServicioRequestDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.ActualizarReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.EliminarReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.InsertarReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.ListarReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.ObtenerReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.application.mapper.ActualizarReservaServicioMapper;
import com.sise.hotel_backend.reservaServicio.application.mapper.EliminarReservaServicioMapper;
import com.sise.hotel_backend.reservaServicio.application.mapper.InsertarReservaServicioMapper;
import com.sise.hotel_backend.reservaServicio.application.mapper.ListarReservaServicioMapper;
import com.sise.hotel_backend.reservaServicio.application.mapper.ObtenerReservaServicioMapper;
import com.sise.hotel_backend.reservaServicio.domain.entities.ReservaServicio;
import com.sise.hotel_backend.reservaServicio.domain.service.ReservaServicioDomainService;

@Service
public class ReservaServicioApplicationService {
    
    @Autowired
    ReservaServicioDomainService reservaServicioDomainService;

    @Autowired
    InsertarReservaServicioMapper insertarReservaServicioMapper;
    @Autowired
    ListarReservaServicioMapper listarReservaServicioMapper;
    @Autowired
    ObtenerReservaServicioMapper obtenerReservaServicioMapper;
    @Autowired
    ActualizarReservaServicioMapper actualizarReservaServicioMapper;
    @Autowired
    EliminarReservaServicioMapper eliminarReservaServicioMapper;

    public InsertarReservaServicioResponseDto insertarReservaServicio(
        InsertarReservaServicioRequestDto requestDto) {
        ReservaServicio reservaServicio = reservaServicioDomainService.insertarReservaServicio(
                insertarReservaServicioMapper.requestToEntity(requestDto));
        return insertarReservaServicioMapper.entityToResponse(reservaServicio);
    }

    public List<ListarReservaServicioResponseDto> listarReservaServicios() {
        List<ReservaServicio> reservaServicio = reservaServicioDomainService.listarReservaServicios();
        return reservaServicio.stream().map(listarReservaServicioMapper::entityToResponse).toList();
    }

    public ObtenerReservaServicioResponseDto obtenerReservaServicioPorId(Integer id) {
        Optional<ReservaServicio> reservaServicio = 
        reservaServicioDomainService.obtenerReservaServicio(id);
        return reservaServicio.stream().map(obtenerReservaServicioMapper::entityToResponse)
                .findFirst()
                .orElse(null);
    }

    public ActualizarReservaServicioResponseDto actualizarReservaServicio(Integer id, 
    ActualizarReservaServicioRequestDto requestDto) {
        ReservaServicio reservaServicio = reservaServicioDomainService.actualizarReservaServicio(id,
                actualizarReservaServicioMapper.requestToEntity(requestDto));
        return actualizarReservaServicioMapper.entityToResponse(reservaServicio);
    }

    public EliminarReservaServicioResponseDto eliminarReservaServicio(Integer id) {
        reservaServicioDomainService.eliminarReservaServicio(id);
        return eliminarReservaServicioMapper.entityToResponse(true);
    }
}
