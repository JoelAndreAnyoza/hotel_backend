package com.sise.hotel_backend.reserva.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.common.domain.enums.EstadoAuditoria;
import com.sise.hotel_backend.reserva.domain.entities.Reserva;
import com.sise.hotel_backend.reserva.domain.repository.ReservaRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservaDomainService {

    @Autowired
    ReservaRepository reservaRepository;

    public Reserva insertarReserva(Reserva reserva) {
        validarFechas(reserva);
        Reserva newreserva = reservaRepository.saveAndFlush(reserva);
        return reservaRepository.findById(newreserva.getIdReserva()).orElse(null);
    }

    public List<Reserva> listarReserva() {
        return reservaRepository.findByEstadoAuditoria(EstadoAuditoria.ACTIVO);
    }

    public Optional<Reserva> obtenerReserva(Integer id) {
        return reservaRepository.findById(id);
    }

    public Reserva actualizarReserva(Integer id, Reserva reserva) {
        validarFechas(reserva);
        if (reservaRepository.existsById(id)) {
            reserva.setIdReserva(id);
            return reservaRepository.saveAndFlush(reserva);
        }
        throw new RuntimeException("Reserva no encontrada");
    }

    @Transactional
    public void darBajaReserva(Integer idReserva) {
        if (!reservaRepository.existsById(idReserva)) {
            throw new IllegalStateException("La reserva con id " + idReserva + " no existe.");
        }
        reservaRepository.darBajaReserva(idReserva);
    }

    private void validarFechas(Reserva reserva) {
        if (reserva.getFechaSalida() != null && reserva.getFechaIngreso() != null &&
                !reserva.getFechaSalida().isAfter(reserva.getFechaIngreso())) {
            throw new IllegalArgumentException("La fecha de salida debe ser posterior a la fecha de ingreso");
        }
    }
}
