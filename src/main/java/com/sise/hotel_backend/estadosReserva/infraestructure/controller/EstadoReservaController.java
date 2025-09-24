package com.sise.hotel_backend.estadosReserva.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sise.hotel_backend.estadosReserva.application.dto.request.EstadoReservaRequestDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.EstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.service.EstadoReservaApplicationService;
import com.sise.hotel_backend.estadosReserva.domain.entities.EstadoReserva;

@Controller
@RequestMapping("/estadosReserva")
public class EstadoReservaController {
    @Autowired
    private EstadoReservaApplicationService estadoReservaApplicationService;

    @PostMapping("")
    public ResponseEntity<EstadoReservaResponseDto> insertarEstadoReserva(@RequestBody EstadoReservaRequestDto requestDto) {
        try {
            EstadoReservaResponseDto responseDto = estadoReservaApplicationService.insertarEstadoReserva(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<EstadoReserva>> listarEstadosReserva() {
        return ResponseEntity.ok(estadoReservaApplicationService.listarEstadoReserva());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoReserva> obtenerEstadoReservaPorId(@PathVariable Integer id) {
        Optional<EstadoReserva> estadoReserva = estadoReservaApplicationService.obtenerEstadoReservaPorId(id);
        return estadoReserva.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoReserva> actualizarEstadoReserva(@PathVariable Integer id, @RequestBody EstadoReserva estadoReserva) {
        estadoReserva.setIdEstadoReserva(id);
        EstadoReserva updated = estadoReservaApplicationService.actualizarEstadoReserva(estadoReserva);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstadoReserva(@PathVariable Integer id) {
        if (estadoReservaApplicationService.eliminarEstadoReserva(id)) {
            return ResponseEntity.ok("Estado de Reserva eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }
}
