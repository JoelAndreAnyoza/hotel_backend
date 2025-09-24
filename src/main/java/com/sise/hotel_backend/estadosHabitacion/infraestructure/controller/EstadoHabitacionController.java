package com.sise.hotel_backend.estadosHabitacion.infraestructure.controller;

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

import com.sise.hotel_backend.estadosHabitacion.application.dto.request.EstadoHabitacionRequestDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.EstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.service.EstadoHabitacionApplicationService;
import com.sise.hotel_backend.estadosHabitacion.domain.entities.EstadosHabitacion;

@RestController
@RequestMapping("/estadosHabitacion")
public class EstadoHabitacionController {
    
    @Autowired
    private EstadoHabitacionApplicationService estadoHabitacionApplicationService;

    @PostMapping("")
    public ResponseEntity<EstadoHabitacionResponseDto> insertarEstadoHabitacion(
        @RequestBody EstadoHabitacionRequestDto requestDto) {
            try {
                EstadoHabitacionResponseDto responseDto = estadoHabitacionApplicationService.insertarEstadoHabitacion(requestDto);
                return ResponseEntity.ok(responseDto);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }

    @GetMapping("")
    public ResponseEntity<List<EstadosHabitacion>> listarEstadoHabitacion() {
        return ResponseEntity.ok(estadoHabitacionApplicationService.listarEstadoHabitacion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadosHabitacion> obtenerEstadoHabitacion(@PathVariable Integer id) {
        Optional<EstadosHabitacion> estadoHabitacion = estadoHabitacionApplicationService.obtenerEstadoHabitacion(id);
        return estadoHabitacion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadosHabitacion> actualizarEstadoHabitacion(@PathVariable Integer id, 
    @RequestBody EstadosHabitacion estadosHabitacion) {
        estadosHabitacion.setIdEstadoHabitacion(id);
        EstadosHabitacion updated = estadoHabitacionApplicationService.actualizarEstadoHabitacion(estadosHabitacion);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstadoHabitacion(@PathVariable Integer id) {
        if (estadoHabitacionApplicationService.eliminarEstadoHabitacion(id)) {
            return ResponseEntity.ok("Estado de Habitacion eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }

}
