package com.sise.hotel_backend.servicio.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.servicio.application.dto.request.ServicioRequestDto;
import com.sise.hotel_backend.servicio.application.dto.response.ServicioResponseDto;
import com.sise.hotel_backend.servicio.domain.entities.Servicio;
import com.sise.hotel_backend.servicio.application.mapper.ServicioMapper;
import com.sise.hotel_backend.servicio.domain.service.ServicioDomainService;

@Service
public class ServicioApplicationService {

    @Autowired
    ServicioDomainService servicioDomainService;

    @Autowired
    ServicioMapper servicioMapper;

    public ServicioResponseDto insertarServicio(ServicioRequestDto requestDto) {
        Servicio servicio = servicioDomainService.insertarServicio(
                servicioMapper.requestToEntity(requestDto));
        return servicioMapper.entityToResponse(servicio);
    }

    public List<Servicio> listarServicios() {
        return servicioDomainService.listarServicios();
    }

    public Optional<Servicio> obtenerServicioPorId(Integer id) {
        return servicioDomainService.obtenerServicio(id);
    }

    public Servicio actualizarServicio(Servicio servicio) {
        return servicioDomainService.actualizarServicio(servicio);
    }

    public boolean eliminarServicio(Integer id) {
        return servicioDomainService.eliminarServicio(id);
    }

}
