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

    public EstadoReserva actualizarEstadoReserva(Integer id, EstadoReserva estadoReserva) {
        if (estadoReservaRepository.existsById(id)) {
            estadoReserva.setIdEstadoReserva(id);
            return estadoReservaRepository.saveAndFlush(estadoReserva);
        }
        return null;
    }

    public void darBajaEstadoReserva(Integer idEstadoReserva) {
        estadoReservaRepository.darBajaEstadoReserva(idEstadoReserva);
    }
}
