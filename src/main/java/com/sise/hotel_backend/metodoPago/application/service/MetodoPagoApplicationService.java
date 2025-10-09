package com.sise.hotel_backend.metodoPago.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.metodoPago.application.dto.request.ActualizarMetodoPagoRequestDto;
import com.sise.hotel_backend.metodoPago.application.dto.request.InsertarMetodoPagoRequestDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.ActualizarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.EliminarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.InsertarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.ListarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.ObtenerMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.mapper.ActualizarMetodoPagoMapper;
import com.sise.hotel_backend.metodoPago.application.mapper.EliminarMetodoPagoMapper;
import com.sise.hotel_backend.metodoPago.application.mapper.InsertarMetodoPagoMapper;
import com.sise.hotel_backend.metodoPago.application.mapper.ListarMetodoPagoMapper;
import com.sise.hotel_backend.metodoPago.application.mapper.ObtenerMetodoPagoMapper;
import com.sise.hotel_backend.metodoPago.domain.entities.MetodoPago;
import com.sise.hotel_backend.metodoPago.domain.service.MetodoPagoDomainService;

@Service
public class MetodoPagoApplicationService {

    @Autowired
    MetodoPagoDomainService metodoPagoDomainService;

    @Autowired
    InsertarMetodoPagoMapper insertarMetodoPagoMapper;
    @Autowired
    ListarMetodoPagoMapper listarMetodoPagoMapper;
    @Autowired
    ObtenerMetodoPagoMapper obtenerMetodoPagoMapper;
    @Autowired
    ActualizarMetodoPagoMapper actualizarMetodoPagoMapper;
    @Autowired
    EliminarMetodoPagoMapper eliminarMetodoPagoMapper;

    public InsertarMetodoPagoResponseDto insertarMetodoPago(InsertarMetodoPagoRequestDto requestDto) {
        MetodoPago metodoPago = metodoPagoDomainService.insertarMetodoPago(
                insertarMetodoPagoMapper.requestToEntity(requestDto));
        return insertarMetodoPagoMapper.entityToResponse(metodoPago);
    }

    public List<ListarMetodoPagoResponseDto> listarMetodosPago() {
        List<MetodoPago> metodoPago = metodoPagoDomainService.listarMetodosPago();
        return metodoPago.stream().map(listarMetodoPagoMapper::entityToResponse).toList();    
    }

    public ObtenerMetodoPagoResponseDto obtenerMetodoPagoPorId(Integer id) {
        Optional<MetodoPago> metodoPago = metodoPagoDomainService.obtenerMetodoPago(id);
        return metodoPago.stream().map(obtenerMetodoPagoMapper::entityToResponse)
                .findFirst()
                .orElse(null);    
    }

    public ActualizarMetodoPagoResponseDto actualizarMetodoPago(Integer id, 
    ActualizarMetodoPagoRequestDto requestDto) {
        MetodoPago metodoPago = metodoPagoDomainService.actualizarMetodoPago(id,
                actualizarMetodoPagoMapper.requestToEntity(requestDto));
        return actualizarMetodoPagoMapper.entityToResponse(metodoPago);
    }

    public EliminarMetodoPagoResponseDto darBajaMetodoPago(Integer id) {
        metodoPagoDomainService.darBajaMetodoPago(id);
        return eliminarMetodoPagoMapper.entityToResponse(true);
    }
}
