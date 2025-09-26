package com.sise.hotel_backend.usuario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.common.application.IEntityDtoMapper;
import com.sise.hotel_backend.usuario.application.dto.request.InsertarUsuarioRequestDto;
import com.sise.hotel_backend.usuario.application.dto.response.InsertarUsuarioResponseDto;
import com.sise.hotel_backend.usuario.domain.entities.Usuario;

@Component
public class InsertarUsuarioMapper implements IEntityDtoMapper<Usuario, InsertarUsuarioRequestDto, InsertarUsuarioResponseDto>{
    
    @Override
    public Usuario requestToEntity(InsertarUsuarioRequestDto requestDto) {
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
    public InsertarUsuarioResponseDto entityToResponse(Usuario entity) {
        InsertarUsuarioResponseDto responseDto = new InsertarUsuarioResponseDto();
        responseDto.setIdUsuario(entity.getIdUsuario());
        responseDto.setIdTipoDocumento(entity.getIdTipoDocumento());
        responseDto.setUsername(entity.getUsername());
        responseDto.setEmail(entity.getEmail());
        responseDto.setContrasenia(entity.getContrasenia());
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
