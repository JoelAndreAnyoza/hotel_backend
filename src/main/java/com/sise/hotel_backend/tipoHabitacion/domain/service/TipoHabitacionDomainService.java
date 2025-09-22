package com.sise.hotel_backend.tipoHabitacion.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.tipoHabitacion.domain.entities.TipoHabitacion;
import com.sise.hotel_backend.tipoHabitacion.domain.repository.TipoHabitacionRepository;

@Service
public class TipoHabitacionDomainService {
    
    @Autowired
    TipoHabitacionRepository tipoHabitacionRepository;

    public TipoHabitacion insertarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        TipoHabitacion newTipoHabitacion = tipoHabitacionRepository.saveAndFlush(tipoHabitacion);
        return tipoHabitacionRepository.findById(newTipoHabitacion.getIdTipoHabitacion()).orElse(null);
    }

    public Optional<TipoHabitacion> obtenerTipoHabitacion(Integer id) {
        return tipoHabitacionRepository.findById(id);
    }

    public List<TipoHabitacion> listarTipoHabitacions(){
        return tipoHabitacionRepository.findAll();
    }

    public TipoHabitacion actualizarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        if (tipoHabitacionRepository.existsById(tipoHabitacion.getIdTipoHabitacion())) {
            return tipoHabitacionRepository.saveAndFlush(tipoHabitacion);
        }
        return null;
    }

    public boolean eliminarTipoHabitacion(Integer id) {
        if (tipoHabitacionRepository.existsById(id)) {
            tipoHabitacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
