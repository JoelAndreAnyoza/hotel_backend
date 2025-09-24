package com.sise.hotel_backend.habitacion.infraestructure.controller;

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

import com.sise.hotel_backend.habitacion.application.dto.request.HabitacionRequestDto;
import com.sise.hotel_backend.habitacion.application.dto.response.HabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.service.HabitacionApplicationService;
import com.sise.hotel_backend.habitacion.domain.entities.Habitacion;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {
    @Autowired
    private HabitacionApplicationService habitacionApplicationService;

    @PostMapping("")
    public ResponseEntity<HabitacionResponseDto> insertarHabitacion(@RequestBody HabitacionRequestDto requestDto) {
        try {
            HabitacionResponseDto responseDto = habitacionApplicationService.insertarHabitacion(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Habitacion>> listarHabitaciones() {
        return ResponseEntity.ok(habitacionApplicationService.listarHabitacion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> obtenerHabitacionPorId(@PathVariable Integer id) {
        Optional<Habitacion> habitacion = habitacionApplicationService.obtenerHabitacionPorId(id);
        return habitacion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> actualizarHabitacion(@PathVariable Integer id, @RequestBody Habitacion habitacion) {
        habitacion.setIdHabitacion(id);
        Habitacion updated = habitacionApplicationService.actualizarHabitacion(habitacion);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarHabitacion(@PathVariable Integer id) {
        if (habitacionApplicationService.eliminarHabitacion(id)) {
            return ResponseEntity.ok("Habitación eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }
}
