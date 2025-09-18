package com.sise.hotel_backend.login.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.login.application.dto.request.InsertarLoginRequestDto;
import com.sise.hotel_backend.login.application.dto.response.InsertarLoginResponseDto;
import com.sise.hotel_backend.login.application.mapper.InsertarLoginMapper;
import com.sise.hotel_backend.login.domain.entities.Login;
import com.sise.hotel_backend.login.domain.service.LoginDomainService;

@Service
public class LoginApplicationService {

    @Autowired
    LoginDomainService loginDomainService;

    @Autowired
    InsertarLoginMapper insertarLoginMapper;

    public InsertarLoginResponseDto insertarLogin(InsertarLoginRequestDto requestDto) {
        Login login = loginDomainService.insertarLogin(
            insertarLoginMapper.requestToEntity(requestDto));
        return insertarLoginMapper.entityToResponse(login);
    }

    public List<Login> listarLogin(){
        return loginDomainService.listarLogin();
    }

    public Optional<Login> obtenerLoginPorId(Integer id) {
        return loginDomainService.obtenerLoginPorId(id);
    }

    public Login actualizarLogin(Login login) {
        return loginDomainService.actualizarLogin(login);
    }

    public boolean eliminarLogin(Integer id) {
        return loginDomainService.eliminarLogin(id);
    }
    
}
