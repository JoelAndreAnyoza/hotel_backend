package com.sise.hotel_backend.comodidad.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.comodidad.domain.entities.Comodidad;
import com.sise.hotel_backend.comodidad.domain.repository.ComodidadRepository;

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
        return comodidadRepository.findAll();
    }

    public Comodidad actualizarComodidad(Integer id, Comodidad comodidad) {
        if (comodidadRepository.existsById(id)) {
            comodidad.setIdComodidad(id);
            return comodidadRepository.saveAndFlush(comodidad);
        }
        return null;
    }

    public void eliminarComodidad(Integer id) {
        if (comodidadRepository.existsById(id)) {
            comodidadRepository.deleteById(id);
        } else {
            throw new RuntimeException("Comodidad no encontrada");
        }
    }

    public void darBajaComodidad(Integer idComodidad) {
        // Comodidad comodidad = comodidadRepository.findById(id).orElse(null);
        // if (comodidad != null) {
        //     comodidad.setEstadoAuditoria(EstadoAuditoria.INACTIVO);
        //     comodidadRepository.save(comodidad);
        // } else {
        //     throw new RuntimeException("Comodidad no encontrada");
        // }

        comodidadRepository.darBajaComodidad(idComodidad);
    }
}
