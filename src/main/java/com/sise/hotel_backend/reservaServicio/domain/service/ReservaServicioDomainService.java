package com.sise.hotel_backend.reservaServicio.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.reservaServicio.domain.entities.ReservaServicio;
import com.sise.hotel_backend.reservaServicio.domain.repository.ReservaServicioRepository;

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
        return reservaServicioRepository.findAll();
    }

    public Optional<ReservaServicio> obtenerReservaServicio(Integer id) {
        return reservaServicioRepository.findById(id);
    }

    public ReservaServicio actualizarReservaServicio(Integer id, ReservaServicio reservaServicio) {
        if (reservaServicioRepository.existsById(id)) {
            reservaServicio.setIdReservaServicio(id);
            return reservaServicioRepository.saveAndFlush(reservaServicio);
        }
        return null;
    }

    public void darBajaReservaServicio(Integer idReservaServicio){
        reservaServicioRepository.darBajaReservaServicio(idReservaServicio);
    }
}
