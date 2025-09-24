package com.sise.hotel_backend.usuario.application.dto.request;

import lombok.Data;

@Data
public class UsuarioRequestDto {
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
}
