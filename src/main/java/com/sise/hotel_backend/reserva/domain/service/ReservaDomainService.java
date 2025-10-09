package com.sise.hotel_backend.reserva.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.reserva.domain.entities.Reserva;
import com.sise.hotel_backend.reserva.domain.repository.ReservaRepository;

@Service
public class ReservaDomainService {

    @Autowired
    ReservaRepository reservaRepository;

    public Reserva insertarReserva(Reserva reserva) {
        Reserva newreserva = reservaRepository.saveAndFlush(reserva);
        return reservaRepository.findById(newreserva.getIdReserva()).orElse(null);
    }

    public List<Reserva> listarReserva() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> obtenerReserva(Integer id) {
        return reservaRepository.findById(id);
    }

    public Reserva actualizarReserva(Integer id, Reserva reserva) {
        if (reservaRepository.existsById(id)) {
            reserva.setIdReserva(id);
            return reservaRepository.saveAndFlush(reserva);
        }
        return null;
    }

    public void eliminarReserva(Integer id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Reserva no encontrada");
        }
    }
}
