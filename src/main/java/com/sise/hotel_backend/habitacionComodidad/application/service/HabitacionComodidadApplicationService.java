package com.sise.hotel_backend.habitacionComodidad.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.habitacionComodidad.application.dto.request.ActualizarHabitacionComodidadRequestDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.request.InsertarHabitacionComodidadRequestDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.ActualizarHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.EliminarHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.InsertarHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.ListarHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.ObtenerHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.application.mapper.ActualizarHabitacionComodidadMapper;
import com.sise.hotel_backend.habitacionComodidad.application.mapper.EliminarHabitacionComodidadMapper;
import com.sise.hotel_backend.habitacionComodidad.application.mapper.InsertarHabitacionComodidadMapper;
import com.sise.hotel_backend.habitacionComodidad.application.mapper.ListarHabitacionComodidadMapper;
import com.sise.hotel_backend.habitacionComodidad.application.mapper.ObtenerHabitacionComodidadMapper;
import com.sise.hotel_backend.habitacionComodidad.domain.entities.HabitacionComodidad;
import com.sise.hotel_backend.habitacionComodidad.domain.service.HabitacionComodidadDomainService;

@Service
public class HabitacionComodidadApplicationService {
    @Autowired
    HabitacionComodidadDomainService habitacionComodidadDomainService;

    @Autowired
    InsertarHabitacionComodidadMapper insertarHabitacionComodidadMapper;
    @Autowired
    ListarHabitacionComodidadMapper listarHabitacionComodidadMapper;
    @Autowired
    ObtenerHabitacionComodidadMapper obtenerHabitacionComodidadMapper;
    @Autowired
    ActualizarHabitacionComodidadMapper actualizarHabitacionComodidadMapper;
    @Autowired
    EliminarHabitacionComodidadMapper eliminarHabitacionComodidadMapper;

    public InsertarHabitacionComodidadResponseDto insertarHabitacionComodidad(
        InsertarHabitacionComodidadRequestDto requestDto) {
        HabitacionComodidad habitacionComodidad = 
        habitacionComodidadDomainService.insertarHabitacionComodidad(
                insertarHabitacionComodidadMapper.requestToEntity(requestDto));
        return insertarHabitacionComodidadMapper.entityToResponse(habitacionComodidad);
    }

    public List<ListarHabitacionComodidadResponseDto> listarHabitacionComodidad() {
        List<HabitacionComodidad> habitacionComodidad = 
        habitacionComodidadDomainService.listarHabitacionComodidades();
        return habitacionComodidad.stream()
                .map(listarHabitacionComodidadMapper::entityToResponse).toList();  
    }

    public ObtenerHabitacionComodidadResponseDto obtenerHabitacionComodidad(Integer id) {
        Optional<HabitacionComodidad> habitacionComodidad = 
                habitacionComodidadDomainService.obtenerHabitacionComodidad(id);
        return habitacionComodidad.stream().map(obtenerHabitacionComodidadMapper::entityToResponse)
                .findFirst()
                .orElse(null);   
    }

    public ActualizarHabitacionComodidadResponseDto actualizarHabitacionComodidad(Integer id,
        ActualizarHabitacionComodidadRequestDto requestDto) {
        HabitacionComodidad habitacionComodidad = 
        habitacionComodidadDomainService.actualizarHabitacionComodidad(id,
                actualizarHabitacionComodidadMapper.requestToEntity(requestDto));
        return actualizarHabitacionComodidadMapper.entityToResponse(habitacionComodidad);
    }

    public EliminarHabitacionComodidadResponseDto darBajaHabitacionComodidad(Integer id) {
        habitacionComodidadDomainService.darBajaHabitacionComodidad(id);
        return eliminarHabitacionComodidadMapper.entityToResponse(true);
    }
}
