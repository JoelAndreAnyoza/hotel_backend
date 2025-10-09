package com.sise.hotel_backend.habitacionComodidad.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.common.domain.enums.EstadoAuditoria;
import com.sise.hotel_backend.habitacionComodidad.domain.entities.HabitacionComodidad;
import com.sise.hotel_backend.habitacionComodidad.domain.repository.HabitacionComodidadRepository;

import jakarta.transaction.Transactional;

@Service
public class HabitacionComodidadDomainService {

    @Autowired
    HabitacionComodidadRepository habitacionComodidadRepository;

    public HabitacionComodidad insertarHabitacionComodidad(HabitacionComodidad habitacionComodidad) {
        HabitacionComodidad newHabitacionComodidad = 
        habitacionComodidadRepository.saveAndFlush(habitacionComodidad);
        return habitacionComodidadRepository.findById(
            newHabitacionComodidad.getIdRelacion()).orElse(null);
    }

    public List<HabitacionComodidad> listarHabitacionComodidades() {
        return habitacionComodidadRepository.findByEstadoAuditoria(EstadoAuditoria.ACTIVO);
    }

    public Optional<HabitacionComodidad> obtenerHabitacionComodidad(Integer id) {
        return habitacionComodidadRepository.findById(id);
    }

    public HabitacionComodidad actualizarHabitacionComodidad(Integer id, 
    HabitacionComodidad habitacionComodidad) {
        if (habitacionComodidadRepository.existsById(id)) {
            habitacionComodidad.setIdRelacion(id);
            return habitacionComodidadRepository.saveAndFlush(habitacionComodidad);
        }
        return null;
    }
    
    @Transactional
    public void darBajaHabitacionComodidad(Integer idHabitacionComodidad) {
        if (!habitacionComodidadRepository.existsById(idHabitacionComodidad)) {
            throw new RuntimeException("Habitación Comodidad no encontrado");
        }
        habitacionComodidadRepository.darBajaHabitacionComodidad(idHabitacionComodidad);
    }
}