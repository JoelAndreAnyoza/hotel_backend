package com.sise.hotel_backend.habitacion.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.habitacion.application.dto.request.HabitacionRequestDto;
import com.sise.hotel_backend.habitacion.application.dto.response.HabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.mapper.HabitacionMapper;
import com.sise.hotel_backend.habitacion.domain.entities.Habitacion;
import com.sise.hotel_backend.habitacion.domain.service.HabitacionDomainService;

@Service
public class HabitacionApplicationService {
    @Autowired
    HabitacionDomainService habitacionDomainService;

    @Autowired
    HabitacionMapper habitacionMapper;

    public HabitacionResponseDto insertarHabitacion(HabitacionRequestDto requestDto) {
        Habitacion habitacion = habitacionDomainService.insertarHabitacion(
                habitacionMapper.requestToEntity(requestDto));
        return habitacionMapper.entityToResponse(habitacion);
    }

    public List<Habitacion> listarHabitacion() {
        return habitacionDomainService.listarHabitaciones();
    }

    public Optional<Habitacion> obtenerHabitacionPorId(Integer id) {
        return habitacionDomainService.obtenerHabitacion(id);
    }

    public Habitacion actualizarHabitacion(Habitacion habitacion) {
        return habitacionDomainService.actualizarHabitacion(habitacion);
    }

    public boolean eliminarHabitacion(Integer id) {
        return habitacionDomainService.eliminarHabitacion(id);
    }
}
