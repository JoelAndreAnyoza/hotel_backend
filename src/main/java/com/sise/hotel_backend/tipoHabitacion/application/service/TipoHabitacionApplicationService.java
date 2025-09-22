package com.sise.hotel_backend.tipoHabitacion.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.tipoHabitacion.application.dto.request.TipoHabitacionRequestDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.TipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.mapper.TipoHabitacionMapper;
import com.sise.hotel_backend.tipoHabitacion.domain.entities.TipoHabitacion;
import com.sise.hotel_backend.tipoHabitacion.domain.service.TipoHabitacionDomainService;

@Service
public class TipoHabitacionApplicationService {

    @Autowired
    TipoHabitacionDomainService tipoHabitacionDomainService;

    @Autowired
    TipoHabitacionMapper tipoHabitacionMapper;

    public TipoHabitacionResponseDto insertarTipoHabitacion(TipoHabitacionRequestDto requestDto) {
        TipoHabitacion tipoHabitacion = tipoHabitacionDomainService.insertarTipoHabitacion(
            tipoHabitacionMapper.requestToEntity(requestDto));
        return tipoHabitacionMapper.entityToResponse(tipoHabitacion);
    }

    public List<TipoHabitacion> listarTipoHabitacion() {
        return tipoHabitacionDomainService.listarTipoHabitacions();
    }

    public Optional<TipoHabitacion> obtenerTipoHabitacionPorId(Integer id) {
        return tipoHabitacionDomainService.obtenerTipoHabitacion(id);
    }

    public TipoHabitacion actualizarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionDomainService.actualizarTipoHabitacion(tipoHabitacion);
    }

    public boolean eliminarTipoHabitacion(Integer id) {
        return tipoHabitacionDomainService.eliminarTipoHabitacion(id);
    }
    
}
