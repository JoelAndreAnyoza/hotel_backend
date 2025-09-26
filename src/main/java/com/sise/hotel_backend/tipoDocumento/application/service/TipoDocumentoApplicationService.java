package com.sise.hotel_backend.tipoDocumento.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.tipoDocumento.application.dto.request.ActualizarTipoDocumentoRequestDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.request.InsertarTipoDocumentoRequestDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.ActualizarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.EliminarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.InsertarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.ListarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.ObtenerTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.mapper.ActualizarTipoDocumentoMapper;
import com.sise.hotel_backend.tipoDocumento.application.mapper.EliminarTipoDocumentoMapper;
import com.sise.hotel_backend.tipoDocumento.application.mapper.InsertarTipoDocumentoMapper;
import com.sise.hotel_backend.tipoDocumento.application.mapper.ListarTipoDocumentoMapper;
import com.sise.hotel_backend.tipoDocumento.application.mapper.ObtenerTipoDocumentoMapper;
import com.sise.hotel_backend.tipoDocumento.domain.entities.TipoDocumento;
import com.sise.hotel_backend.tipoDocumento.domain.service.TipoDocumentoDomainService;

@Service
public class TipoDocumentoApplicationService {
    
    @Autowired
    TipoDocumentoDomainService tipoDocumentoDomainService;

    @Autowired
    InsertarTipoDocumentoMapper insertarTipoDocumentoMapper;
    @Autowired
    ListarTipoDocumentoMapper listarTipoDocumentoMapper;
    @Autowired
    ObtenerTipoDocumentoMapper obtenerTipoDocumentoMapper;
    @Autowired
    ActualizarTipoDocumentoMapper actualizarTipoDocumentoMapper;
    @Autowired
    EliminarTipoDocumentoMapper eliminarTipoDocumentoMapper;

    public InsertarTipoDocumentoResponseDto insertarTipoDocumento(InsertarTipoDocumentoRequestDto requestDto) {
        TipoDocumento tipoDocumento = tipoDocumentoDomainService.insertarTipoDocumento(
            insertarTipoDocumentoMapper.requestToEntity(requestDto));
            return insertarTipoDocumentoMapper.entityToResponse(tipoDocumento);
    }

    public List<ListarTipoDocumentoResponseDto> listarTipoDocumento() {
        List<TipoDocumento> tipoDocumentos = tipoDocumentoDomainService.listarTipoDocumento();
        return tipoDocumentos.stream().map(listarTipoDocumentoMapper::entityToResponse).toList();
    }

    public ObtenerTipoDocumentoResponseDto obtenerTipoDocumentoPorId(Integer id) {
        Optional<TipoDocumento> tipoDocumento = tipoDocumentoDomainService.obtenerTipoDocumento(id);
        return tipoDocumento.stream().map(obtenerTipoDocumentoMapper::entityToResponse)
                .findFirst()
                .orElse(null);
    }

    public ActualizarTipoDocumentoResponseDto actualizarTipoDocumento(Integer id, 
    ActualizarTipoDocumentoRequestDto requestDto) {
        TipoDocumento tipoDocumento = tipoDocumentoDomainService.actualizarTipoDocumento(id,
                actualizarTipoDocumentoMapper.requestToEntity(requestDto));
        return actualizarTipoDocumentoMapper.entityToResponse(tipoDocumento);
    }

    public EliminarTipoDocumentoResponseDto eliminarTipoDocumento(Integer id) {
        tipoDocumentoDomainService.eliminarTipoDocumento(id);
        return eliminarTipoDocumentoMapper.entityToResponse(true);
    }
}
