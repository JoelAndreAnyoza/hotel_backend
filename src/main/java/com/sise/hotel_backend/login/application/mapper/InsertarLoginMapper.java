package com.sise.hotel_backend.login.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.login.application.dto.request.InsertarLoginRequestDto;
import com.sise.hotel_backend.login.application.dto.response.InsertarLoginResponseDto;
import com.sise.hotel_backend.login.domain.entities.Login;

@Component
public class InsertarLoginMapper implements 
    IEntityDtoMapper<Login, InsertarLoginRequestDto, InsertarLoginResponseDto>{
    
    @Override
    public Login requestToEntity(InsertarLoginRequestDto requestDto) {
        Login login = new Login();
        login.setUsuario(requestDto.getUsuario());
        login.setContrasena(requestDto.getContrasena());
        login.setRol(requestDto.getRol());
        login.setIdCliente(requestDto.getIdCliente());
        login.setIdEmpleado(requestDto.getIdEmpleado());
        return login;
    }

    @Override
    public InsertarLoginResponseDto entityToResponse(Login entity) {
        InsertarLoginResponseDto responseDto = new InsertarLoginResponseDto();
        responseDto.setIdLogin(entity.getIdLogin());
        responseDto.setUsuario(entity.getUsuario());
        responseDto.setRol(entity.getRol());
        responseDto.setIdCliente(entity.getIdCliente());
        responseDto.setIdEmpleado(entity.getIdEmpleado());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
