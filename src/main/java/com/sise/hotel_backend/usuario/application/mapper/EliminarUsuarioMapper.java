package com.sise.hotel_backend.usuario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.usuario.application.dto.response.EliminarUsuarioResponseDto;

@Component
public class EliminarUsuarioMapper {
    public EliminarUsuarioResponseDto entityToResponse(boolean eliminado) {

        EliminarUsuarioResponseDto responseDto = new EliminarUsuarioResponseDto();
        if (eliminado) {
            responseDto.setMensaje("Eliminado correctamente");
        } else {
            responseDto.setMensaje("No se pudo eliminar");
        }
        return responseDto;
    }
}
