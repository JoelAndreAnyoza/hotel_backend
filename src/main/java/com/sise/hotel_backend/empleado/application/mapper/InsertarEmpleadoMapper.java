package com.sise.hotel_backend.empleado.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.empleado.application.dto.request.InsertarEmpleadoRequestDto;
import com.sise.hotel_backend.empleado.application.dto.response.InsertarEmpleadoResponseDto;
import com.sise.hotel_backend.empleado.domain.entities.Empleado;

@Component
public class InsertarEmpleadoMapper implements 
    IEntityDtoMapper<Empleado, InsertarEmpleadoRequestDto, InsertarEmpleadoResponseDto>{
    
    @Override
    public Empleado requestToEntity(InsertarEmpleadoRequestDto requestDto) {
        Empleado empleado = new Empleado();
        empleado.setNombres(requestDto.getNombres());
        empleado.setApellidoPaterno(requestDto.getApellidoPaterno());
        empleado.setApellidoMaterno(requestDto.getApellidoMaterno());
        empleado.setCargo(requestDto.getCargo());
        return empleado;
    }

    @Override
    public InsertarEmpleadoResponseDto entityToResponse(Empleado entity) {
        InsertarEmpleadoResponseDto responseDto = new InsertarEmpleadoResponseDto();
        responseDto.setIdEmpleado(entity.getIdEmpleado());
        responseDto.setNombres(entity.getNombres());
        responseDto.setApellidoPaterno(entity.getApellidoPaterno());
        responseDto.setApellidoPaterno(entity.getApellidoMaterno());
        responseDto.setCargo(entity.getCargo());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
