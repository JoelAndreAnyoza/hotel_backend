package com.sise.hotel_backend.estadosHabitacion.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.estadosHabitacion.application.dto.request.EstadoHabitacionRequestDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.EstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.mapper.EstadoHabitacionMapper;
import com.sise.hotel_backend.estadosHabitacion.domain.entities.EstadosHabitacion;
import com.sise.hotel_backend.estadosHabitacion.domain.service.EstadosHabitacionDomainService;

@Service
public class EstadoHabitacionApplicationService {
    
    @Autowired
    EstadosHabitacionDomainService estadosHabitacionDomainService;

    @Autowired
    EstadoHabitacionMapper estadoHabitacionMapper;

    public EstadoHabitacionResponseDto insertarEstadoHabitacion(EstadoHabitacionRequestDto requestDto) {
        EstadosHabitacion estadosHabitacion = estadosHabitacionDomainService.insertarEstadoHabitacion(
            estadoHabitacionMapper.requestToEntity(requestDto));
        return estadoHabitacionMapper.entityToResponse(estadosHabitacion);
    }

    public List<EstadosHabitacion> listarEstadoHabitacion(){
        return estadosHabitacionDomainService.listarEstadoHabitacion();
    }

    public Optional<EstadosHabitacion> obtenerEstadoHabitacion(Integer id) {
        return estadosHabitacionDomainService.obtenerEstadoHabitacion(id);
    }

    public EstadosHabitacion actualizarEstadoHabitacion(EstadosHabitacion estadosHabitacion) {
        return estadosHabitacionDomainService.actualizarEstadosHabitacion(estadosHabitacion);
    }

    public boolean eliminarEstadoHabitacion(Integer id){
        return estadosHabitacionDomainService.eliminarEstadoHabitacion(id);
    }
}
