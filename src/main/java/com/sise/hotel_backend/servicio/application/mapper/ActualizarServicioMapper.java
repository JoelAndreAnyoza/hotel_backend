package com.sise.hotel_backend.servicio.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.servicio.application.dto.request.ActualizarServicioRequestDto;
import com.sise.hotel_backend.servicio.application.dto.response.ActualizarServicioResponseDto;
import com.sise.hotel_backend.servicio.domain.entities.Servicio;

@Component
public class ActualizarServicioMapper 
implements IEntityDtoMapper<Servicio, ActualizarServicioRequestDto, ActualizarServicioResponseDto>{
    
    @Override
    public Servicio requestToEntity(ActualizarServicioRequestDto requestDto) {
        Servicio servicio = new Servicio();
        servicio.setNombre(requestDto.getNombre());
        servicio.setDescripcion(requestDto.getDescripcion());
        servicio.setPrecio(requestDto.getPrecio());
        return servicio;
    }

    @Override
    public ActualizarServicioResponseDto entityToResponse(Servicio entity) {
        ActualizarServicioResponseDto responseDto = new ActualizarServicioResponseDto();
        responseDto.setIdServicio(entity.getIdServicio());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setPrecio(entity.getPrecio());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
