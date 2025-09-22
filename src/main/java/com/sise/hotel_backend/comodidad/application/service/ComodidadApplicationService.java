package com.sise.hotel_backend.comodidad.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.comodidad.application.dto.response.ComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.mapper.ComodidadMapper;
import com.sise.hotel_backend.comodidad.domain.service.ComodidadDomainService;
import com.sise.hotel_backend.comodidad.application.dto.request.ComodidadRequestDto;
import com.sise.hotel_backend.comodidad.domain.entities.Comodidad;

@Service
public class ComodidadApplicationService {
    @Autowired
    ComodidadDomainService comodidadDomainService;

    @Autowired
    ComodidadMapper comodidadMapper;

    public ComodidadResponseDto insertarComodidad(ComodidadRequestDto requestDto) {
        Comodidad comodidad = comodidadDomainService.insertarComodidad(
                comodidadMapper.requestToEntity(requestDto));
        return comodidadMapper.entityToResponse(comodidad);
    }

    public List<Comodidad> listarComodidades() {
        return comodidadDomainService.listarComodidades();
    }

    public Optional<Comodidad> obtenerComodidadPorId(Integer id) {
        return comodidadDomainService.obtenerComodidad(id);
    }

    public Comodidad actualizarComodidad(Comodidad comodidad) {
        return comodidadDomainService.actualizarComodidad(comodidad);
    }

    public boolean eliminarComodidad(Integer id) {
        return comodidadDomainService.eliminarComodidad(id);
    }
}
