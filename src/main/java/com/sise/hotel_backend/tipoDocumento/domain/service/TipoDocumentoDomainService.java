package com.sise.hotel_backend.tipoDocumento.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.common.domain.enums.EstadoAuditoria;
import com.sise.hotel_backend.tipoDocumento.domain.entities.TipoDocumento;
import com.sise.hotel_backend.tipoDocumento.domain.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoDomainService {

    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumento insertarTipoDocumento(TipoDocumento tipoDocumento){
        TipoDocumento newTipoDocumento = tipoDocumentoRepository.saveAndFlush(tipoDocumento);
        return tipoDocumentoRepository.findById(newTipoDocumento.getIdTipoDocumento()).orElse(null);
    }

    public Optional<TipoDocumento> obtenerTipoDocumento(Integer id) {
        return tipoDocumentoRepository.findById(id);
    }

    public List<TipoDocumento> listarTipoDocumento(){
        return tipoDocumentoRepository.findByEstadoAuditoria(EstadoAuditoria.ACTIVO);
    }

    public TipoDocumento actualizarTipoDocumento(Integer id, TipoDocumento tipoDocumento) {
        if (tipoDocumentoRepository.existsById(id)) {
            tipoDocumento.setIdTipoDocumento(id);
            return tipoDocumentoRepository.saveAndFlush(tipoDocumento);
        }
        return null;
    }

    public void darBajaTipoDocumento(Integer id) {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(id).orElse(null);
        if (tipoDocumento != null) {
            tipoDocumento.setEstadoAuditoria(EstadoAuditoria.INACTIVO);
            tipoDocumentoRepository.save(tipoDocumento);
        } else {
            throw new RuntimeException("Tipo de Documento no encontrado");
        }
    }
}
