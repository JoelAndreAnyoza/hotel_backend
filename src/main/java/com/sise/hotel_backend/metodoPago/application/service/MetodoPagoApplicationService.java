package com.sise.hotel_backend.metodoPago.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.metodoPago.application.dto.request.MetodoPagoRequestDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.MetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.mapper.InsertarMetodoPagoMapper;
import com.sise.hotel_backend.metodoPago.domain.entities.MetodoPago;
import com.sise.hotel_backend.metodoPago.domain.service.MetodoPagoDomainService;

@Service
public class MetodoPagoApplicationService {

    @Autowired
    MetodoPagoDomainService metodoPagoDomainService;

    @Autowired
    InsertarMetodoPagoMapper insertarMetodoPagoMapper;

    public MetodoPagoResponseDto insertarMetodoPago(MetodoPagoRequestDto requestDto) {
        MetodoPago metodoPago = metodoPagoDomainService.insertarMetodoPago(
                insertarMetodoPagoMapper.requestToEntity(requestDto));
        return insertarMetodoPagoMapper.entityToResponse(metodoPago);
    }

    public List<MetodoPago> listarMetodosPago() {
        return metodoPagoDomainService.listarMetodosPago();
    }

    public Optional<MetodoPago> obtenerMetodoPagoPorId(Integer id) {
        return metodoPagoDomainService.obtenerMetodoPago(id);
    }

    public MetodoPago actualizarMetodoPago(MetodoPago metodoPago) {
        return metodoPagoDomainService.actualizarMetodoPago(metodoPago);
    }

    public boolean eliminarMetodoPago(Integer id) {
        return metodoPagoDomainService.eliminarMetodoPago(id);
    }
}
