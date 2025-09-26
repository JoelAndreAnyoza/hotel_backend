package com.sise.hotel_backend.metodoPago.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.metodoPago.domain.entities.MetodoPago;
import com.sise.hotel_backend.metodoPago.domain.repository.MetodoPagoRepository;

@Service
public class MetodoPagoDomainService {

    @Autowired
    MetodoPagoRepository metodoPagoRepository;

    public MetodoPago insertarMetodoPago(MetodoPago metodoPago) {
        MetodoPago newMetodoPago = metodoPagoRepository.saveAndFlush(metodoPago);
        return metodoPagoRepository.findById(newMetodoPago.getIdMetodoPago()).orElse(null);
    }

    public List<MetodoPago> listarMetodosPago() {
        return metodoPagoRepository.findAll();
    }

    public Optional<MetodoPago> obtenerMetodoPago(Integer id) {
        return metodoPagoRepository.findById(id);
    }

    public MetodoPago actualizarMetodoPago(Integer id, MetodoPago metodoPago) {
        if (metodoPagoRepository.existsById(id)) {
            metodoPago.setIdMetodoPago(id);
            return metodoPagoRepository.saveAndFlush(metodoPago);
        }
        return null;
    }

    public void eliminarMetodoPago(Integer id) {
        if (metodoPagoRepository.existsById(id)) {
            metodoPagoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Metodo de Pago no encontrado");
        }
    }
}
