package com.sise.hotel_backend.servicio.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.common.domain.enums.EstadoAuditoria;
import com.sise.hotel_backend.servicio.domain.entities.Servicio;
import com.sise.hotel_backend.servicio.domain.repository.ServicioRepository;

import jakarta.transaction.Transactional;

@Service
public class ServicioDomainService {

    @Autowired
    ServicioRepository servicioRepository;

    public Servicio insertarServicio(Servicio servicio) {
        Servicio newServicio = servicioRepository.saveAndFlush(servicio);
        return servicioRepository.findById(newServicio.getIdServicio()).orElse(null);
    }

    public List<Servicio> listarServicios() {
        return servicioRepository.findByEstadoAuditoria(EstadoAuditoria.ACTIVO);
    }

    public Optional<Servicio> obtenerServicio(Integer id) {
        if (!servicioRepository.existsById(id)) {
            throw new RuntimeException("Servicio no encontrado");
        }
        return servicioRepository.findById(id);
    }

    public Servicio actualizarServicio(Integer id, Servicio servicio) {
        if (servicioRepository.existsById(id)) {
            servicio.setIdServicio(id);
            return servicioRepository.saveAndFlush(servicio);
        }
        throw new RuntimeException("Servicio no encontrado");
    }

    @Transactional
    public void darBajaServicio(Integer idServicio) {
        if (!servicioRepository.existsById(idServicio)) {
            throw new RuntimeException("Servicio no encontrado");
        }
        servicioRepository.darBajaServicio(idServicio);
    }
}
