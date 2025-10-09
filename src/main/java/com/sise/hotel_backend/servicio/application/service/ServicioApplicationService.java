package com.sise.hotel_backend.servicio.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.servicio.application.dto.request.ActualizarServicioRequestDto;
import com.sise.hotel_backend.servicio.application.dto.request.InsertarServicioRequestDto;
import com.sise.hotel_backend.servicio.application.dto.response.ActualizarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.EliminarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.InsertarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.ListarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.ObtenerServicioResponseDto;
import com.sise.hotel_backend.servicio.domain.entities.Servicio;
import com.sise.hotel_backend.servicio.application.mapper.ActualizarServicioMapper;
import com.sise.hotel_backend.servicio.application.mapper.EliminarServicioMapper;
import com.sise.hotel_backend.servicio.application.mapper.InsertarServicioMapper;
import com.sise.hotel_backend.servicio.application.mapper.ListarServicioMapper;
import com.sise.hotel_backend.servicio.application.mapper.ObtenerServicioMapper;
import com.sise.hotel_backend.servicio.domain.service.ServicioDomainService;

@Service
public class ServicioApplicationService {

    @Autowired
    ServicioDomainService servicioDomainService;

    @Autowired
    InsertarServicioMapper insertarServicioMapper;
    @Autowired
    ListarServicioMapper listarServicioMapper;
    @Autowired
    ObtenerServicioMapper obtenerServicioMapper;
    @Autowired
    ActualizarServicioMapper actualizarServicioMapper;
    @Autowired
    EliminarServicioMapper eliminarServicioMapper;

    public InsertarServicioResponseDto insertarServicio(InsertarServicioRequestDto requestDto) {
        Servicio servicio = servicioDomainService.insertarServicio(
                insertarServicioMapper.requestToEntity(requestDto));
        return insertarServicioMapper.entityToResponse(servicio);
    }

    public List<ListarServicioResponseDto> listarServicios() {
        List<Servicio> servicio = servicioDomainService.listarServicios();
        return servicio.stream().map(listarServicioMapper::entityToResponse).toList();
    }

    public ObtenerServicioResponseDto obtenerServicioPorId(Integer id) {
        Optional<Servicio> servicio = servicioDomainService.obtenerServicio(id);
        return servicio.stream().map(obtenerServicioMapper::entityToResponse)
                .findFirst()
                .orElse(null);
    }

    public ActualizarServicioResponseDto actualizarServicio(Integer id, 
    ActualizarServicioRequestDto requestDto) {
        Servicio servicio = servicioDomainService.actualizarServicio(id,
                actualizarServicioMapper.requestToEntity(requestDto));
        return actualizarServicioMapper.entityToResponse(servicio);
    }

    public EliminarServicioResponseDto eliminarServicio(Integer id) {
        servicioDomainService.eliminarServicio(id);
        return eliminarServicioMapper.entityToResponse(true);
    }

}
