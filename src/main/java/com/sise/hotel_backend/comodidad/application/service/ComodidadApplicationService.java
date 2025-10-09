package com.sise.hotel_backend.comodidad.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.comodidad.application.dto.response.ActualizarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.EliminarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.InsertarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.ListarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.ObtenerComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.mapper.ActualizarComodidadMapper;
import com.sise.hotel_backend.comodidad.application.mapper.EliminarComodidadMapper;
import com.sise.hotel_backend.comodidad.application.mapper.InsertarComodidadMapper;
import com.sise.hotel_backend.comodidad.application.mapper.ListarComodidadMapper;
import com.sise.hotel_backend.comodidad.application.mapper.ObtenerComodidadMapper;
import com.sise.hotel_backend.comodidad.domain.service.ComodidadDomainService;
import com.sise.hotel_backend.comodidad.application.dto.request.ActualizarComodidadRequestDto;
import com.sise.hotel_backend.comodidad.application.dto.request.InsertarComodidadRequestDto;
import com.sise.hotel_backend.comodidad.domain.entities.Comodidad;

@Service
public class ComodidadApplicationService {
    @Autowired
    ComodidadDomainService comodidadDomainService;

    @Autowired
    InsertarComodidadMapper insertarComodidadMapper;
    @Autowired
    ListarComodidadMapper listarComodidadMapper;
    @Autowired
    ObtenerComodidadMapper obtenerComodidadMapper;
    @Autowired
    ActualizarComodidadMapper actualizarComodidadMapper;
    @Autowired
    EliminarComodidadMapper eliminarComodidadMapper;

    public InsertarComodidadResponseDto insertarComodidad(InsertarComodidadRequestDto requestDto) {
        Comodidad comodidad = comodidadDomainService.insertarComodidad(
                insertarComodidadMapper.requestToEntity(requestDto));
        return insertarComodidadMapper.entityToResponse(comodidad);
    }

    public List<ListarComodidadResponseDto> listarComodidades() {
        List<Comodidad> comodidad = comodidadDomainService.listarComodidades();
        return comodidad.stream()
                .map(listarComodidadMapper::entityToResponse)
                .toList();
    }

    public ObtenerComodidadResponseDto obtenerComodidadPorId(Integer id) {
        Optional<Comodidad> comodidad = comodidadDomainService.obtenerComodidad(id);
        return comodidad.stream()
                .map(obtenerComodidadMapper::entityToResponse)
                .findFirst()
                .orElse(null);
    }

    public ActualizarComodidadResponseDto actualizarComodidad(Integer id, 
    ActualizarComodidadRequestDto requestDto) {
        Comodidad comodidad = comodidadDomainService.actualizarComodidad(id,
                actualizarComodidadMapper.requestToEntity(requestDto));
        return actualizarComodidadMapper.entityToResponse(comodidad);
    }

    public EliminarComodidadResponseDto darBajaComodidad(Integer id) {
        comodidadDomainService.darBajaComodidad(id);
        return eliminarComodidadMapper.entityToResponse(true);
    }
}
