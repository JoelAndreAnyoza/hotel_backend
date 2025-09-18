package com.sise.hotel_backend.login.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.login.domain.entities.Login;
import com.sise.hotel_backend.login.domain.repository.LoginRespository;

@Service
public class LoginDomainService {

    @Autowired
    LoginRespository loginRespository;

    public Login insertarLogin(Login login) {
        Login newLogin = loginRespository.saveAndFlush(login);
        return loginRespository.findById(newLogin.getIdLogin()).orElse(null);
    }

    public Optional<Login> obtenerLoginPorId(Integer id) {
        return loginRespository.findById(id);
    }

    public List<Login> listarLogin() {
        return loginRespository.findAll(); // busca y retorna los elementos
    }

    public Login actualizarLogin(Login login) {
        if (loginRespository.existsById(login.getIdLogin())) {
            return loginRespository.saveAndFlush(login);
        }
        return null;
    }

    public boolean eliminarLogin(Integer id) {
        if (loginRespository.existsById(id)) {
            loginRespository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
