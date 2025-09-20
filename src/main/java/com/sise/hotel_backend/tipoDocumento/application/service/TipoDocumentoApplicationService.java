package com.sise.hotel_backend.tipoDocumento.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.tipoDocumento.application.dto.request.InsertarTipoDocumentoRequestDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.InsertarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.mapper.InsertarTipoDocumentoMapper;
import com.sise.hotel_backend.tipoDocumento.domain.entities.TipoDocumento;
import com.sise.hotel_backend.tipoDocumento.domain.service.TipoDocumentoDomainService;

@Service
public class TipoDocumentoApplicationService {
    
    @Autowired
    TipoDocumentoDomainService tipoDocumentoDomainService;

    @Autowired
    InsertarTipoDocumentoMapper insertarTipoDocumentoMapper;

    public InsertarTipoDocumentoResponseDto insertarTipoDocumento(InsertarTipoDocumentoRequestDto requestDto) {
        TipoDocumento tipoDocumento = tipoDocumentoDomainService.insertarTipoDocumento(
            insertarTipoDocumentoMapper.requestToEntity(requestDto));
            return insertarTipoDocumentoMapper.entityToResponse(tipoDocumento);
    }

    public List<TipoDocumento> listarTipoDocumento() {
        return tipoDocumentoDomainService.listarTipoDocumento();
    }

    public Optional<TipoDocumento> obtenerTipoDocumentoPorId(Integer id) {
        return tipoDocumentoDomainService.obtenerTipoDocumento(id);
    }

    public TipoDocumento actualizarTipoDocumento(TipoDocumento tipoDocumento) {
        return tipoDocumentoDomainService.actualizarTipoDocumento(tipoDocumento);
    }

    public boolean eliminarTipoDocumento(Integer id) {
        return tipoDocumentoDomainService.eliminarTipoDocumento(id);
    }
}
