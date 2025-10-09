package com.sise.hotel_backend.usuario.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.usuario.application.dto.request.ActualizarUsuarioRequestDto;
import com.sise.hotel_backend.usuario.application.dto.request.InsertarUsuarioRequestDto;
import com.sise.hotel_backend.usuario.application.dto.response.ActualizarUsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.dto.response.EliminarUsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.dto.response.InsertarUsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.dto.response.ListarUsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.dto.response.ObtenerUsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.mapper.ActualizarUsuarioMapper;
import com.sise.hotel_backend.usuario.application.mapper.EliminarUsuarioMapper;
import com.sise.hotel_backend.usuario.application.mapper.InsertarUsuarioMapper;
import com.sise.hotel_backend.usuario.application.mapper.ListarUsuarioMapper;
import com.sise.hotel_backend.usuario.application.mapper.ObtenerUsuarioMapper;
import com.sise.hotel_backend.usuario.domain.entities.Usuario;
import com.sise.hotel_backend.usuario.domain.service.UsuarioDomainService;

@Service
public class UsuarioApplicationService{
    
    @Autowired
    UsuarioDomainService usuarioDomainService;

    @Autowired
    InsertarUsuarioMapper insertarUsuarioMapper;
    @Autowired
    ListarUsuarioMapper listarUsuarioMapper;
    @Autowired
    ObtenerUsuarioMapper obtenerUsuarioMapper;
    @Autowired
    ActualizarUsuarioMapper actualizarUsuarioMapper;
    @Autowired
    EliminarUsuarioMapper eliminarUsuarioMapper;
    
    public InsertarUsuarioResponseDto insertarUsuario(InsertarUsuarioRequestDto requestDto) {
        Usuario usuario = usuarioDomainService.insertarUsuario(
            insertarUsuarioMapper.requestToEntity(requestDto));
        return insertarUsuarioMapper.entityToResponse(usuario);
    }

    public List<ListarUsuarioResponseDto> listarUsuarios() {
        List<Usuario> usuario = usuarioDomainService.listarUsuario();
        return usuario.stream().map(listarUsuarioMapper::entityToResponse).toList();
    }

    public ObtenerUsuarioResponseDto obtenerUsuarioPorId(Integer id) {
        Optional<Usuario> usuario = usuarioDomainService.obtenerUsuarioPorId(id);
        return usuario.stream().map(obtenerUsuarioMapper::entityToResponse)
                .findFirst()
                .orElse(null);
    }

    public ActualizarUsuarioResponseDto actualizarUsuario(Integer id, 
    ActualizarUsuarioRequestDto requestDto) {
        Usuario usuario = usuarioDomainService.actualizarUsuario(id,
                actualizarUsuarioMapper.requestToEntity(requestDto));
        return actualizarUsuarioMapper.entityToResponse(usuario);
    }

    public EliminarUsuarioResponseDto eliminarUsuario(Integer id) {
        usuarioDomainService.eliminarUsuario(id);
        return eliminarUsuarioMapper.entityToResponse(true);
    }
}
