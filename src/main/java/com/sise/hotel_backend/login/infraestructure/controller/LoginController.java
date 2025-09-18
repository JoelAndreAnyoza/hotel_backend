package com.sise.hotel_backend.login.infraestructure.controller;

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

import com.sise.hotel_backend.login.application.dto.request.InsertarLoginRequestDto;
import com.sise.hotel_backend.login.application.dto.response.InsertarLoginResponseDto;
import com.sise.hotel_backend.login.application.service.LoginApplicationService;
import com.sise.hotel_backend.login.domain.entities.Login;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginApplicationService loginApplicationService;

    @PostMapping("")
    public ResponseEntity<InsertarLoginResponseDto> insertarLogin(
        @RequestBody InsertarLoginRequestDto requestDto) {
            try {
                InsertarLoginResponseDto responseDto = loginApplicationService.insertarLogin(requestDto);
                return ResponseEntity.ok(responseDto);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }

    @GetMapping("")
    public ResponseEntity<List<Login>> listarLogin() {
        return ResponseEntity.ok(loginApplicationService.listarLogin());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> obtenerLoginPorId(@PathVariable Integer id) {
        Optional<Login> login = loginApplicationService.obtenerLoginPorId(id);
        return login.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Login> actualizarLogin(@PathVariable Integer id, @RequestBody Login login) {
        login.setIdLogin(id);
        Login updated = loginApplicationService.actualizarLogin(login);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogin(@PathVariable Integer id) {
        if (loginApplicationService.eliminarLogin(id)) {
            return ResponseEntity.ok("Proyecto eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }
}
