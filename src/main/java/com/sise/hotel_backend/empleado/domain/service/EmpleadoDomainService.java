package com.sise.hotel_backend.empleado.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.empleado.domain.entities.Empleado;
import com.sise.hotel_backend.empleado.domain.repository.EmpleadoRepository;

@Service
public class EmpleadoDomainService {
    
    @Autowired
    EmpleadoRepository empleadoRepository;

    public Empleado insertarEmpleado(Empleado empleado) {
        Empleado newEmpleado = empleadoRepository.saveAndFlush(empleado);
        return empleadoRepository.findById(newEmpleado.getIdEmpleado()).orElse(null);
    }

    public Optional<Empleado> obtenerEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id);
    }

    public List<Empleado> listarEmpleado(){
        return empleadoRepository.findAll();
    }

    public Empleado actualizarEmpleado(Empleado empleado) {
        if (empleadoRepository.existsById(empleado.getIdEmpleado())) {
            return empleadoRepository.saveAndFlush(empleado);
        }
        return null;
    }

    public boolean eliminarEmpleado(Integer id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
