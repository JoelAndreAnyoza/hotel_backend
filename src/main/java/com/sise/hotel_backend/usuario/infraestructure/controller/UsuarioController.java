package com.sise.hotel_backend.usuario.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.hotel_backend.common.dto.response.BaseResponseDto;
import com.sise.hotel_backend.usuario.application.dto.request.ActualizarUsuarioRequestDto;
import com.sise.hotel_backend.usuario.application.dto.request.InsertarUsuarioRequestDto;
import com.sise.hotel_backend.usuario.application.dto.response.ActualizarUsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.dto.response.EliminarUsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.dto.response.InsertarUsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.dto.response.ListarUsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.dto.response.ObtenerUsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.service.UsuarioApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con la gestión de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioApplicationService usuarioApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear un nuevo usuario", 
                description = "Permite insertar un nuevo usuario en el sistema")
    public ResponseEntity<BaseResponseDto> insertarUsuario(
        @Valid @RequestBody InsertarUsuarioRequestDto requestDto) {
            try {
                InsertarUsuarioResponseDto responseDto = 
                usuarioApplicationService.insertarUsuario(requestDto);
                return ResponseEntity.ok(BaseResponseDto.success(responseDto));
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
            }
        }
    
    @GetMapping("")
    @Operation(summary = "Listar todos los usuarios", 
                description = "Obtiene una lista con todos los usuarios registrados")
    public ResponseEntity<BaseResponseDto> listarUsuarios(){
        try {
            List<ListarUsuarioResponseDto> responseDto =
            usuarioApplicationService.listarUsuarios();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID", 
                description = "Devuelve la información de un usuario específico según su ID")
    public ResponseEntity<BaseResponseDto> obtenerUsuarioPorId(@PathVariable Integer id) {
        try {
            ObtenerUsuarioResponseDto responseDto =
            usuarioApplicationService.obtenerUsuarioPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario", 
                description = "Actualiza la información de un usuario existente")
    public ResponseEntity<BaseResponseDto> actualizarUsuario(@PathVariable Integer id, 
    @Valid @RequestBody ActualizarUsuarioRequestDto requestDto) {
        try {
            ActualizarUsuarioResponseDto responseDto = 
            usuarioApplicationService.actualizarUsuario(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario", 
                description = "Elimina un usuario del sistema según su ID")
    public ResponseEntity<BaseResponseDto> eliminarUsuario(@PathVariable Integer id) {
        try {
            EliminarUsuarioResponseDto responseDto = 
            usuarioApplicationService.eliminarUsuario(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
    
}
