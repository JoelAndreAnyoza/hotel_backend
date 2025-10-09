package com.sise.hotel_backend.reservaServicio.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.common.domain.enums.EstadoAuditoria;
import com.sise.hotel_backend.reservaServicio.domain.entities.ReservaServicio;
import com.sise.hotel_backend.reservaServicio.domain.repository.ReservaServicioRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservaServicioDomainService {

    @Autowired
    ReservaServicioRepository reservaServicioRepository;

    public ReservaServicio insertarReservaServicio(ReservaServicio reservaServicio) {
        ReservaServicio newReservaServicio = reservaServicioRepository.saveAndFlush(reservaServicio);
        return reservaServicioRepository.findById(newReservaServicio.getIdReservaServicio())
                .orElse(null);
    }

    public List<ReservaServicio> listarReservaServicios() {
        return reservaServicioRepository.findByEstadoAuditoria(EstadoAuditoria.ACTIVO);
    }

    public Optional<ReservaServicio> obtenerReservaServicio(Integer id) {
        if (!reservaServicioRepository.existsById(id)) {
            throw new RuntimeException("Reserva de Servicio no encontrado");
        }
        return reservaServicioRepository.findById(id);
    }

    public ReservaServicio actualizarReservaServicio(Integer id, ReservaServicio reservaServicio) {
        if (reservaServicioRepository.existsById(id)) {
            reservaServicio.setIdReservaServicio(id);
            return reservaServicioRepository.saveAndFlush(reservaServicio);
        }
        throw new RuntimeException("Reserva de Servicio no encontrado");
    }

    @Transactional
    public void darBajaReservaServicio(Integer idReservaServicio) {
        if (!reservaServicioRepository.existsById(idReservaServicio)) {
            throw new RuntimeException("Reserva de Servicio no encontrado");
        }
        reservaServicioRepository.darBajaReservaServicio(idReservaServicio);
    }
}
