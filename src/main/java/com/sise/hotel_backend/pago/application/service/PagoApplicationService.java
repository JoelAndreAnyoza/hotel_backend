package com.sise.hotel_backend.pago.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.pago.application.dto.request.ActualizarPagoRequestDto;
import com.sise.hotel_backend.pago.application.dto.request.InsertarPagoRequestDto;
import com.sise.hotel_backend.pago.application.dto.response.ActualizarPagoResponseDto;
import com.sise.hotel_backend.pago.application.dto.response.EliminarPagoResponseDto;
import com.sise.hotel_backend.pago.application.dto.response.InsertarPagoResponseDto;
import com.sise.hotel_backend.pago.application.dto.response.ListarPagoResponseDto;
import com.sise.hotel_backend.pago.application.dto.response.ObtenerPagoResponseDto;
import com.sise.hotel_backend.pago.application.mapper.ActualizarPagoMapper;
import com.sise.hotel_backend.pago.application.mapper.EliminarPagoMapper;
import com.sise.hotel_backend.pago.application.mapper.InsertarPagoMapper;
import com.sise.hotel_backend.pago.application.mapper.ListarPagoMapper;
import com.sise.hotel_backend.pago.application.mapper.ObtenerPagoMapper;
import com.sise.hotel_backend.pago.domain.entities.Pago;
import com.sise.hotel_backend.pago.domain.service.PagoDomainService;

@Service
public class PagoApplicationService {
    
    @Autowired
    PagoDomainService pagoDomainService;

    @Autowired
    InsertarPagoMapper insertarPagoMapper;
    @Autowired
    ListarPagoMapper listarPagoMapper;
    @Autowired
    ObtenerPagoMapper obtenerPagoMapper;
    @Autowired
    ActualizarPagoMapper actualizarPagoMapper;
    @Autowired
    EliminarPagoMapper eliminarPagoMapper;

    public InsertarPagoResponseDto insertarPago(InsertarPagoRequestDto requestDto) {
        Pago pago = pagoDomainService.insertarPago(
                insertarPagoMapper.requestToEntity(requestDto));
        return insertarPagoMapper.entityToResponse(pago);
    }

    public List<ListarPagoResponseDto> listarPago() {
        List<Pago> pago = pagoDomainService.listarPago();
        return pago.stream().map(listarPagoMapper::entityToResponse).toList();    
    }

    public ObtenerPagoResponseDto obtenerPagoPorId(Integer id) {
        Optional<Pago> pago = pagoDomainService.obtenerPago(id);
        return pago.stream().map(obtenerPagoMapper::entityToResponse).findFirst()
                .orElse(null);    
    }

    public ActualizarPagoResponseDto actualizarPago(Integer id, ActualizarPagoRequestDto requestDto) {
        Pago pago = pagoDomainService.actualizarPago(id,
                actualizarPagoMapper.requestToEntity(requestDto));
        return actualizarPagoMapper.entityToResponse(pago);
    }

    public EliminarPagoResponseDto eliminarPago(Integer id) {
        pagoDomainService.eliminarPago(id);
        return eliminarPagoMapper.entityToResponse(true);    
    }
}
