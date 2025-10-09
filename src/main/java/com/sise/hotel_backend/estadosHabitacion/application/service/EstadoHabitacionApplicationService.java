package com.sise.hotel_backend.estadosHabitacion.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.estadosHabitacion.application.dto.request.ActualizarEstadoHabitacionRequestDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.request.InsertarEstadoHabitacionRequestDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ActualizarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.EliminarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.InsertarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ListarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ObtenerEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.mapper.ActualizarEstadoHabitacionMapper;
import com.sise.hotel_backend.estadosHabitacion.application.mapper.EliminarEstadoHabitacionMapper;
import com.sise.hotel_backend.estadosHabitacion.application.mapper.InsertarEstadoHabitacionMapper;
import com.sise.hotel_backend.estadosHabitacion.application.mapper.ListarEstadoHabitacionMapper;
import com.sise.hotel_backend.estadosHabitacion.application.mapper.ObtenerEstadoHabitacionMapper;
import com.sise.hotel_backend.estadosHabitacion.domain.entities.EstadosHabitacion;
import com.sise.hotel_backend.estadosHabitacion.domain.service.EstadosHabitacionDomainService;

@Service
public class EstadoHabitacionApplicationService {
    
    @Autowired
    EstadosHabitacionDomainService estadosHabitacionDomainService;

    @Autowired
    InsertarEstadoHabitacionMapper insertarEstadoHabitacionMapper;
    @Autowired 
    ListarEstadoHabitacionMapper listarEstadoHabitacionMapper;
    @Autowired
    ObtenerEstadoHabitacionMapper obtenerEstadoHabitacionMapper;
    @Autowired
    ActualizarEstadoHabitacionMapper actualizarEstadoHabitacionMapper;
    @Autowired
    EliminarEstadoHabitacionMapper eliminarEstadoHabitacionMapper;

    public InsertarEstadoHabitacionResponseDto insertarEstadoHabitacion(InsertarEstadoHabitacionRequestDto requestDto) {
        EstadosHabitacion estadosHabitacion = estadosHabitacionDomainService.insertarEstadoHabitacion(
                insertarEstadoHabitacionMapper.requestToEntity(requestDto));
        return insertarEstadoHabitacionMapper.entityToResponse(estadosHabitacion);
    }

    public List<ListarEstadoHabitacionResponseDto> listarEstadoHabitacion(){
        List<EstadosHabitacion> estadosHabitacion = estadosHabitacionDomainService.listarEstadoHabitacion();
        return estadosHabitacion.stream()
                .map(listarEstadoHabitacionMapper::entityToResponse)
                .toList();
    }
    
    public ObtenerEstadoHabitacionResponseDto obtenerEstadoHabitacion(Integer id) {
        Optional<EstadosHabitacion> estadoHabitacion = estadosHabitacionDomainService.obtenerEstadoHabitacion(id);
        return estadoHabitacion.stream()
                .map(obtenerEstadoHabitacionMapper::entityToResponse)
                .findFirst()
                .orElse(null);
    }

    public ActualizarEstadoHabitacionResponseDto actualizarEstadoHabitacion(Integer id, 
    ActualizarEstadoHabitacionRequestDto requestDto) {
        EstadosHabitacion estadosHabitacion = estadosHabitacionDomainService.actualizarEstadosHabitacion(id,
                actualizarEstadoHabitacionMapper.requestToEntity(requestDto)
        );
        return actualizarEstadoHabitacionMapper.entityToResponse(estadosHabitacion);
    }

    public EliminarEstadoHabitacionResponseDto darBajaEstadoHabitacion(Integer id) {
        estadosHabitacionDomainService.darBajaEstadoHabitacion(id);
        return eliminarEstadoHabitacionMapper.entityToResponse(true);
    }
}
