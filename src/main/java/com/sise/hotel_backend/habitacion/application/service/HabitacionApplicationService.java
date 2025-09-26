package com.sise.hotel_backend.habitacion.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.habitacion.application.dto.request.ActualizarHabitacionRequestDto;
import com.sise.hotel_backend.habitacion.application.dto.request.InsertarHabitacionRequestDto;
import com.sise.hotel_backend.habitacion.application.dto.response.ActualizarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.EliminarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.InsertarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.ListarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.ObtenerHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.mapper.ActualizarHabitacionMapper;
import com.sise.hotel_backend.habitacion.application.mapper.EliminarHabitacionMapper;
import com.sise.hotel_backend.habitacion.application.mapper.InsertarHabitacionMapper;
import com.sise.hotel_backend.habitacion.application.mapper.ListarHabitacionMapper;
import com.sise.hotel_backend.habitacion.application.mapper.ObtenerHabitacionMapper;
import com.sise.hotel_backend.habitacion.domain.entities.Habitacion;
import com.sise.hotel_backend.habitacion.domain.service.HabitacionDomainService;

@Service
public class HabitacionApplicationService {
    @Autowired
    HabitacionDomainService habitacionDomainService;

    @Autowired
    InsertarHabitacionMapper insertarHabitacionMapper;
    @Autowired
    ListarHabitacionMapper listarHabitacionMapper;
    @Autowired
    ObtenerHabitacionMapper obtenerHabitacionMapper;
    @Autowired
    ActualizarHabitacionMapper actualizarHabitacionMapper;
    @Autowired
    EliminarHabitacionMapper eliminarHabitacionMapper;

    public InsertarHabitacionResponseDto insertarHabitacion(InsertarHabitacionRequestDto requestDto) {
        Habitacion habitacion = habitacionDomainService.insertarHabitacion(
                insertarHabitacionMapper.requestToEntity(requestDto));
        return insertarHabitacionMapper.entityToResponse(habitacion);
    }

    public List<ListarHabitacionResponseDto> listarHabitacion() {
        List<Habitacion> habitacions = habitacionDomainService.listarHabitaciones();
        return habitacions.stream()
                .map(listarHabitacionMapper::entityToResponse)
                .toList();
    }

    public ObtenerHabitacionResponseDto obtenerHabitacionPorId(Integer id) {
        Optional<Habitacion> habitacion = habitacionDomainService.obtenerHabitacion(id);
        return habitacion.stream()
                .map(obtenerHabitacionMapper::entityToResponse)
                .findFirst()
                .orElse(null);
    }

    public ActualizarHabitacionResponseDto actualizarHabitacion(Integer id, 
    ActualizarHabitacionRequestDto requestDto) {
        Habitacion habitacion = habitacionDomainService.actualizarHabitacion(id,
                actualizarHabitacionMapper.requestToEntity(requestDto));
        return actualizarHabitacionMapper.entityToResponse(habitacion);
    }

    public EliminarHabitacionResponseDto eliminarHabitacion(Integer id) {
        habitacionDomainService.eliminarHabitacion(id);
        return eliminarHabitacionMapper.entityToResponse(true);    
    }
}
