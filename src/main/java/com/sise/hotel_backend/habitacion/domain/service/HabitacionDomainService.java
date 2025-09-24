package com.sise.hotel_backend.habitacion.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.habitacion.domain.entities.Habitacion;
import com.sise.hotel_backend.habitacion.domain.repository.HabitacionRepository;

@Service
public class HabitacionDomainService {
    @Autowired
    HabitacionRepository habitacionRepository;

    public Habitacion insertarHabitacion(Habitacion habitacion) {
        Habitacion newHabitacion = habitacionRepository.saveAndFlush(habitacion);
        return habitacionRepository.findById(newHabitacion.getIdHabitacion()).orElse(null);
    }

    public Optional<Habitacion> obtenerHabitacion(Integer id) {
        return habitacionRepository.findById(id);
    }

    public List<Habitacion> listarHabitaciones() {
        return habitacionRepository.findAll();
    }

    public Habitacion actualizarHabitacion(Habitacion habitacion) {
        if (habitacionRepository.existsById(habitacion.getIdHabitacion())) {
            return habitacionRepository.saveAndFlush(habitacion);
        }
        return null;
    }

    public boolean eliminarHabitacion(Integer id) {
        if (habitacionRepository.existsById(id)) {
            habitacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
