package com.sise.hotel_backend.estadosHabitacion.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.estadosHabitacion.domain.entities.EstadosHabitacion;
import com.sise.hotel_backend.estadosHabitacion.domain.repository.EstadosHabitacionRepository;

@Service
public class EstadosHabitacionDomainService {
    @Autowired
    EstadosHabitacionRepository estadosHabitacionRepository;

    public EstadosHabitacion insertarEstadoHabitacion(EstadosHabitacion estadosHabitacion) {
        EstadosHabitacion newEstadosHabitacion = estadosHabitacionRepository.saveAndFlush(estadosHabitacion);

        return estadosHabitacionRepository.findById(newEstadosHabitacion.getIdEstadoHabitacion()).orElse(null);
    }

    public List<EstadosHabitacion> listarEstadoHabitacion(){
        return estadosHabitacionRepository.findAll();
    }

    public Optional<EstadosHabitacion> obtenerEstadoHabitacion(Integer id){
        return estadosHabitacionRepository.findById(id);
    }

    public EstadosHabitacion actualizarEstadosHabitacion(EstadosHabitacion estadosHabitacion) {
        if (estadosHabitacionRepository.existsById(estadosHabitacion.getIdEstadoHabitacion())) {
            return estadosHabitacionRepository.saveAndFlush(estadosHabitacion);
        }
        return null;
    }

    public boolean eliminarEstadoHabitacion(Integer id) {
        if (estadosHabitacionRepository.existsById(id)) {
            estadosHabitacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
