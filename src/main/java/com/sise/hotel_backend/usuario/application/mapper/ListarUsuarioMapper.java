package com.sise.hotel_backend.usuario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.usuario.application.dto.response.ListarUsuarioResponseDto;
import com.sise.hotel_backend.usuario.domain.entities.Usuario;

@Component
public class ListarUsuarioMapper {
    public ListarUsuarioResponseDto entityToResponse(Usuario entity) {
        if (entity == null) {
            return null;
        }
        ListarUsuarioResponseDto responseDto = new ListarUsuarioResponseDto();
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
