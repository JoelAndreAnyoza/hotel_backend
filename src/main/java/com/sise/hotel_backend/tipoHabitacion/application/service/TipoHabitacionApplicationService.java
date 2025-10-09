package com.sise.hotel_backend.tipoHabitacion.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.tipoHabitacion.application.dto.request.ActualizarTipoHabitacionRequestDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.request.InsertarTipoHabitacionRequestDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.ActualizarTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.EliminarTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.InsertarTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.ListarTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.ObtenerTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.mapper.ActualizarTipoHabitacionMapper;
import com.sise.hotel_backend.tipoHabitacion.application.mapper.EliminarTipoHabitacionMapper;
import com.sise.hotel_backend.tipoHabitacion.application.mapper.InsertarTipoHabitacionMapper;
import com.sise.hotel_backend.tipoHabitacion.application.mapper.ListarTipoHabitacionMapper;
import com.sise.hotel_backend.tipoHabitacion.application.mapper.ObtenerTipoHabitacionMapper;
import com.sise.hotel_backend.tipoHabitacion.domain.entities.TipoHabitacion;
import com.sise.hotel_backend.tipoHabitacion.domain.service.TipoHabitacionDomainService;

@Service
public class TipoHabitacionApplicationService {

    @Autowired
    TipoHabitacionDomainService tipoHabitacionDomainService;

    @Autowired
    InsertarTipoHabitacionMapper insertarTipoHabitacionMapper;
    @Autowired
    ListarTipoHabitacionMapper listarTipoHabitacionMapper;
    @Autowired
    ObtenerTipoHabitacionMapper obtenerTipoHabitacionMapper;
    @Autowired
    ActualizarTipoHabitacionMapper actualizarTipoHabitacionMapper;
    @Autowired
    EliminarTipoHabitacionMapper eliminarTipoHabitacionMapper;

    public InsertarTipoHabitacionResponseDto insertarTipoHabitacion(InsertarTipoHabitacionRequestDto requestDto) {
        TipoHabitacion tipoHabitacion = tipoHabitacionDomainService.insertarTipoHabitacion(
            insertarTipoHabitacionMapper.requestToEntity(requestDto));
        return insertarTipoHabitacionMapper.entityToResponse(tipoHabitacion);
    }

    public List<ListarTipoHabitacionResponseDto> listarTipoHabitacion() {
        List<TipoHabitacion> tipoHabitacions = tipoHabitacionDomainService.listarTipoHabitacions();
        return tipoHabitacions.stream().map(listarTipoHabitacionMapper::entityToResponse).toList();
    }

    public ObtenerTipoHabitacionResponseDto obtenerTipoHabitacionPorId(Integer id) {
        Optional<TipoHabitacion> tipoHabitacion = tipoHabitacionDomainService.obtenerTipoHabitacion(id);
        return tipoHabitacion.stream().map(obtenerTipoHabitacionMapper::entityToResponse)
                .findFirst()
                .orElse(null);
    }

    public ActualizarTipoHabitacionResponseDto actualizarTipoHabitacion(Integer id, 
    ActualizarTipoHabitacionRequestDto requestDto) {
        TipoHabitacion tipoHabitacion = tipoHabitacionDomainService.actualizarTipoHabitacion(id,
                actualizarTipoHabitacionMapper.requestToEntity(requestDto));
        return actualizarTipoHabitacionMapper.entityToResponse(tipoHabitacion);
    }

    public EliminarTipoHabitacionResponseDto eliminarTipoHabitacion(Integer id) {
        tipoHabitacionDomainService.eliminarTipoHabitacion(id);
        return eliminarTipoHabitacionMapper.entityToResponse(true);
    }
    
}
