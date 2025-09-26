package com.sise.hotel_backend.tipoDocumento.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return tipoDocumentoRepository.findAll();
    }

    public TipoDocumento actualizarTipoDocumento(Integer id, TipoDocumento tipoDocumento) {
        if (tipoDocumentoRepository.existsById(id)) {
            tipoDocumento.setIdTipoDocumento(id);
            return tipoDocumentoRepository.saveAndFlush(tipoDocumento);
        }
        return null;
    }

    public void eliminarTipoDocumento(Integer id) {
        if (tipoDocumentoRepository.existsById(id)) {
            tipoDocumentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tipo de Documento no encontrado");
        }
    }
}
