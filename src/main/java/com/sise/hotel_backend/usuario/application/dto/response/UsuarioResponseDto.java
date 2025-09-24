package com.sise.hotel_backend.usuario.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsuarioResponseDto {
    private Integer idUsuario;
    private Integer idTipoDocumento;
    private String username;
    private String email;
    private String contrasenia;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nroDocumento;
    private String telefono;
    private String direccion;
    private LocalDateTime fechaCreacion;
}
