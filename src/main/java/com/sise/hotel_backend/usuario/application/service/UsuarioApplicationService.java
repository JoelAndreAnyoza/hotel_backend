package com.sise.hotel_backend.usuario.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.usuario.application.dto.request.UsuarioRequestDto;
import com.sise.hotel_backend.usuario.application.dto.response.UsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.mapper.UsuarioMapper;
import com.sise.hotel_backend.usuario.domain.entities.Usuario;
import com.sise.hotel_backend.usuario.domain.service.UsuarioDomainService;

@Service
public class UsuarioApplicationService{
    
    @Autowired
    UsuarioDomainService usuarioDomainService;

    @Autowired
    UsuarioMapper usuarioMapper;
    
    public UsuarioResponseDto insertarUsuario(UsuarioRequestDto requestDto) {
        Usuario usuario = usuarioDomainService.insertarUsuario(
            usuarioMapper.requestToEntity(requestDto));
        return usuarioMapper.entityToResponse(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDomainService.listarUsuario();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Integer id) {
        return usuarioDomainService.obtenerUsuarioPorId(id);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioDomainService.actualizarUsuario(usuario);
    }

    public boolean eliminarUsuario(Integer id) {
        return usuarioDomainService.eliminarUsuario(id);
    }
}
