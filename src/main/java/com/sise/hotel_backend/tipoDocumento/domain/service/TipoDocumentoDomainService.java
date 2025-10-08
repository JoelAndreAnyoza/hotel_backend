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
        Optional<TipoDocumento> tipoDoc = tipoDocumentoRepository.findByNombre(tipoDocumento.getNombre());
        if (tipoDoc.isPresent()) {
            throw new RuntimeException("El nombre del tipo de documento ya existe");
        }
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
        TipoDocumento existente = tipoDocumentoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Tipo de Documento no encontrado"));
        Optional<TipoDocumento> duplicado = tipoDocumentoRepository.findByNombre(tipoDocumento.getNombre());

        if (duplicado.isPresent() && !duplicado.get().getIdTipoDocumento().equals(id)) {
            throw new RuntimeException("El nombre del tipo de documento ya existe");
        }
        if (tipoDocumento.getEstadoAuditoria() == null) {
            tipoDocumento.setEstadoAuditoria(existente.getEstadoAuditoria());
        }
        tipoDocumento.setIdTipoDocumento(id);
        return tipoDocumentoRepository.saveAndFlush(tipoDocumento);
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
