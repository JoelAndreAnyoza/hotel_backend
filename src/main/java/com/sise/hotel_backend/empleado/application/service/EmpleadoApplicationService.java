package com.sise.hotel_backend.empleado.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.empleado.application.dto.request.InsertarEmpleadoRequestDto;
import com.sise.hotel_backend.empleado.application.dto.response.InsertarEmpleadoResponseDto;
import com.sise.hotel_backend.empleado.application.mapper.InsertarEmpleadoMapper;
import com.sise.hotel_backend.empleado.domain.entities.Empleado;
import com.sise.hotel_backend.empleado.domain.service.EmpleadoDomainService;

@Service
public class EmpleadoApplicationService {

    @Autowired
    EmpleadoDomainService empleadoDomainService;
    
    @Autowired
    InsertarEmpleadoMapper insertarEmpleadoMapper;

    public InsertarEmpleadoResponseDto insertarEmpleado(InsertarEmpleadoRequestDto requestDto) {
        Empleado empleado = empleadoDomainService.insertarEmpleado(
            insertarEmpleadoMapper.requestToEntity(requestDto));
        return insertarEmpleadoMapper.entityToResponse(empleado);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoDomainService.listarEmpleado();
    }

    public Optional<Empleado> obtenerEmpleadoPorId(Integer id) {
        return empleadoDomainService.obtenerEmpleadoPorId(id);
    }

    public Empleado actualizarEmpleado(Empleado empleado) {
        return empleadoDomainService.actualizarEmpleado(empleado);
    }

    public boolean eliminarEmpleado(Integer id) {
        return empleadoDomainService.eliminarEmpleado(id);
    }
}
