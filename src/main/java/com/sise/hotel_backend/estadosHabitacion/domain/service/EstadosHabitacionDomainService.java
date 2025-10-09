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

    public EstadosHabitacion actualizarEstadosHabitacion(Integer id, EstadosHabitacion estadosHabitacion) {
        if (estadosHabitacionRepository.existsById(id)) {
            estadosHabitacion.setIdEstadoHabitacion(id);
            return estadosHabitacionRepository.saveAndFlush(estadosHabitacion);
        }
        return null;
    }

    public void darBajaEstadoHabitacion(Integer idEstadoHabitacion){
        estadosHabitacionRepository.darBajaEstadoHabitacion(idEstadoHabitacion);
    }
}
