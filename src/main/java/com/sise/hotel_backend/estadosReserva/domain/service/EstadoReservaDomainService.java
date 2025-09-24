package com.sise.hotel_backend.estadosReserva.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.estadosReserva.domain.entities.EstadoReserva;
import com.sise.hotel_backend.estadosReserva.domain.repository.EstadoReservaRepository;

@Service
public class EstadoReservaDomainService {
    
    @Autowired
    EstadoReservaRepository estadoReservaRepository;

    public EstadoReserva insertarEstadoReserva(EstadoReserva estadoReserva) {
        EstadoReserva newEstadoReserva = estadoReservaRepository.saveAndFlush(estadoReserva);
        return estadoReservaRepository.findById(newEstadoReserva.getIdEstadoReserva()).orElse(null);
    }

    public Optional<EstadoReserva> obtenerEstadoReserva(Integer id) {
        return estadoReservaRepository.findById(id);
    }

    public List<EstadoReserva> listarEstadoReservas() {
        return estadoReservaRepository.findAll();
    }

    public EstadoReserva actualizarEstadoReserva(EstadoReserva estadoReserva) {
        if (estadoReservaRepository.existsById(estadoReserva.getIdEstadoReserva())) {
            return estadoReservaRepository.saveAndFlush(estadoReserva);
        }
        return null;
    }

    public boolean eliminarEstadoReserva(Integer id) {
        if (estadoReservaRepository.existsById(id)) {
            estadoReservaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
