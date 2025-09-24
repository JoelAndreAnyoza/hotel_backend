package com.sise.hotel_backend.usuario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.usuario.application.dto.request.UsuarioRequestDto;
import com.sise.hotel_backend.usuario.application.dto.response.UsuarioResponseDto;
import com.sise.hotel_backend.usuario.domain.entities.Usuario;

@Component
public class UsuarioMapper implements IEntityDtoMapper<Usuario, UsuarioRequestDto, UsuarioResponseDto>{
    
    @Override
    public Usuario requestToEntity(UsuarioRequestDto requestDto) {
        Usuario usuario = new Usuario();
        usuario.setIdTipoDocumento(requestDto.getIdTipoDocumento());
        usuario.setUsername(requestDto.getUsername());
        usuario.setEmail(requestDto.getEmail());
        usuario.setContrasenia(requestDto.getContrasenia());
        usuario.setNombres(requestDto.getNombres());
        usuario.setApellidoPaterno(requestDto.getApellidoPaterno());
        usuario.setApellidoMaterno(requestDto.getApellidoMaterno());
        usuario.setNroDocumento(requestDto.getNroDocumento());
        usuario.setTelefono(requestDto.getTelefono());
        usuario.setDireccion(requestDto.getDireccion());
        return usuario;
    }

    @Override
    public UsuarioResponseDto entityToResponse(Usuario entity) {
        UsuarioResponseDto responseDto = new UsuarioResponseDto();
        responseDto.setIdUsuario(entity.getIdUsuario());
        responseDto.setIdTipoDocumento(entity.getIdTipoDocumento());
        responseDto.setUsername(entity.getUsername());
        responseDto.setEmail(entity.getEmail());
        responseDto.setNombres(entity.getNombres());
        responseDto.setApellidoPaterno(entity.getApellidoPaterno());
        responseDto.setApellidoMaterno(entity.getApellidoMaterno());
        responseDto.setNroDocumento(entity.getNroDocumento());
        responseDto.setTelefono(entity.getTelefono());
        responseDto.setDireccion(entity.getDireccion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
