package com.sise.hotel_backend.tipoHabitacion.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.common.domain.enums.EstadoAuditoria;
import com.sise.hotel_backend.tipoHabitacion.domain.entities.TipoHabitacion;
import com.sise.hotel_backend.tipoHabitacion.domain.repository.TipoHabitacionRepository;

import jakarta.transaction.Transactional;

@Service
public class TipoHabitacionDomainService {
    
    @Autowired
    TipoHabitacionRepository tipoHabitacionRepository;

    public TipoHabitacion insertarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        Optional<TipoHabitacion> tipoHab = tipoHabitacionRepository.findByNombre(tipoHabitacion.getNombre());
        if (tipoHab.isPresent()) {
            throw new RuntimeException("El nombre del tipo de habitación ya existe");
        }
        TipoHabitacion newTipoHabitacion = tipoHabitacionRepository.saveAndFlush(tipoHabitacion);
        return tipoHabitacionRepository.findById(newTipoHabitacion.getIdTipoHabitacion()).orElse(null);
    }

    public Optional<TipoHabitacion> obtenerTipoHabitacion(Integer id) {
        if (!tipoHabitacionRepository.existsById(id)) {
            throw new RuntimeException("Tipo de Habitación no encontrado");
        }
        return tipoHabitacionRepository.findById(id);
    }

    public List<TipoHabitacion> listarTipoHabitacions(){
        return tipoHabitacionRepository.findByEstadoAuditoria(EstadoAuditoria.ACTIVO);
    }

    public TipoHabitacion actualizarTipoHabitacion(Integer id, TipoHabitacion tipoHabitacion) {
        TipoHabitacion existente = tipoHabitacionRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Tipo de Habitación no encontrado"));
        Optional<TipoHabitacion> duplicado = tipoHabitacionRepository.findByNombre(tipoHabitacion.getNombre());

        if (duplicado.isPresent() && !duplicado.get().getIdTipoHabitacion().equals(id)) {
            throw new RuntimeException("El nombre del tipo de habitación ya existe");
        }
        if (tipoHabitacion.getEstadoAuditoria() == null) {
            tipoHabitacion.setEstadoAuditoria(existente.getEstadoAuditoria());
        }
        tipoHabitacion.setIdTipoHabitacion(id);
        return tipoHabitacionRepository.saveAndFlush(tipoHabitacion);
    }

    @Transactional // controla las transacciones de base de dato
    public void darBajaTipoHabitacion(Integer idTipoHabitacion) {
        if (!tipoHabitacionRepository.existsById(idTipoHabitacion)) {
            throw new RuntimeException("Tipo de Habitación no encontrado");
        }
        tipoHabitacionRepository.darBajaTipoHabitacion(idTipoHabitacion);
    }
}
