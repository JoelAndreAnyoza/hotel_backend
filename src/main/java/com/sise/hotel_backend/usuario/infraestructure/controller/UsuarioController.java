package com.sise.hotel_backend.usuario.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.hotel_backend.usuario.application.dto.request.UsuarioRequestDto;
import com.sise.hotel_backend.usuario.application.dto.response.UsuarioResponseDto;
import com.sise.hotel_backend.usuario.application.service.UsuarioApplicationService;
import com.sise.hotel_backend.usuario.domain.entities.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioApplicationService usuarioApplicationService;

    @PostMapping("")
    public ResponseEntity<UsuarioResponseDto> insertarUsuario(
        @RequestBody UsuarioRequestDto requestDto) {
            try {
                UsuarioResponseDto responseDto = usuarioApplicationService.insertarUsuario(requestDto);
                return ResponseEntity.ok(responseDto);
            } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }
    
    @GetMapping("")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(usuarioApplicationService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioApplicationService.obtenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);
        Usuario updated = usuarioApplicationService.actualizarUsuario(usuario);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Integer id) {
        if (usuarioApplicationService.eliminarUsuario(id)) {
            return ResponseEntity.ok("Usuario eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }
    
}
