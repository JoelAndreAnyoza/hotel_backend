package com.sise.hotel_backend.usuario.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertarUsuarioRequestDto {
    @NotNull
    @Positive
    private Integer idTipoDocumento;

    @NotBlank
    @Size(min = 3, max = 50, message = "El username debe tener entre 3 y 50 caracteres")
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$", message = "La contraseña debe tener al menos una mayúscula, una minúscula, un número y un carácter especial")
    private String contrasenia;

    @NotBlank
    @Size(min = 1, max = 50)
    private String nombres;

    @NotBlank
    @Size(min = 1, max = 100)
    private String apellidoPaterno;
    
    @NotBlank
    @Size(min = 1, max = 100)
    private String apellidoMaterno;

    @NotBlank
    @Size(min = 8, max = 15)
    @Pattern(regexp = "^[0-9]+$", message = "El número de documento solo puede contener números")
    private String nroDocumento;

    @Pattern(regexp = "^[0-9]{7,10}$", message = "El teléfono debe contener entre 7 y 10 dígitos numéricos")
    private String telefono;

    private String direccion;
}
