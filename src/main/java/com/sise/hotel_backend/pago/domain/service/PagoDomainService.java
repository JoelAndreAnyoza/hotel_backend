package com.sise.hotel_backend.pago.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.pago.domain.entities.Pago;
import com.sise.hotel_backend.pago.domain.repository.PagoRepository;

@Service
public class PagoDomainService {
    
    @Autowired
    PagoRepository pagoRepository;

    public Pago insertarPago(Pago pago) {
        Pago newPago = pagoRepository.saveAndFlush(pago);
        return pagoRepository.findById(newPago.getIdPago()).orElse(null);
    }

    public List<Pago> listarPago() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> obtenerPago(Integer id) {
        return pagoRepository.findById(id);
    }

    public Pago actualizarPago(Integer id, Pago pago) {
        if (pagoRepository.existsById(id)) {
            pago.setIdPago(id);
            return pagoRepository.saveAndFlush(pago);
        }
        return null;
    }

    public void darBajaPago(Integer idPago){
        pagoRepository.darBajaPago(idPago);
    }
}
