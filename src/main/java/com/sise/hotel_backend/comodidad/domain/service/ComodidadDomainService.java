package com.sise.hotel_backend.comodidad.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.common.domain.enums.EstadoAuditoria;
import com.sise.hotel_backend.comodidad.domain.entities.Comodidad;
import com.sise.hotel_backend.comodidad.domain.repository.ComodidadRepository;

import jakarta.transaction.Transactional;

@Service
public class ComodidadDomainService {
    @Autowired
    ComodidadRepository comodidadRepository;

    public Comodidad insertarComodidad(Comodidad comodidad) {
        Comodidad newComodidad = comodidadRepository.saveAndFlush(comodidad);
        return comodidadRepository.findById(newComodidad.getIdComodidad()).orElse(null);
    }

    public Optional<Comodidad> obtenerComodidad(Integer id) {
        return comodidadRepository.findById(id);
    }

    public List<Comodidad> listarComodidades() {
        return comodidadRepository.findByEstadoAuditoria(EstadoAuditoria.ACTIVO);
    }

    public Comodidad actualizarComodidad(Integer id, Comodidad comodidad) {
        if (comodidadRepository.existsById(id)) {
            comodidad.setIdComodidad(id);
            return comodidadRepository.saveAndFlush(comodidad);
        }
        return null;
    }

    @Transactional
    public void darBajaComodidad(Integer idComodidad) {
        comodidadRepository.darBajaComodidad(idComodidad);
    }
}
