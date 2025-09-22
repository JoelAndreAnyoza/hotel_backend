package com.sise.hotel_backend.servicio.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.servicio.domain.entities.Servicio;
import com.sise.hotel_backend.servicio.domain.repository.ServicioRepository;

@Service
public class ServicioDomainService {

    @Autowired
    ServicioRepository servicioRepository;

    public Servicio insertarServicio(Servicio servicio) {
        Servicio newServicio = servicioRepository.saveAndFlush(servicio);
        return servicioRepository.findById(newServicio.getIdServicio()).orElse(null);
    }

    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    public Optional<Servicio> obtenerServicio(Integer id) {
        return servicioRepository.findById(id);
    }

    public Servicio actualizarServicio(Servicio servicio) {
        if (servicioRepository.existsById(servicio.getIdServicio())) {
            return servicioRepository.saveAndFlush(servicio);
        }
        return null;
    }

    public boolean eliminarServicio(Integer id) {
        if (servicioRepository.existsById(id)) {
            servicioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
