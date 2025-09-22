package com.sise.hotel_backend.tipoHabitacion.infraestructure.controller;

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

import com.sise.hotel_backend.tipoHabitacion.application.dto.request.TipoHabitacionRequestDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.TipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.service.TipoHabitacionApplicationService;
import com.sise.hotel_backend.tipoHabitacion.domain.entities.TipoHabitacion;

@RestController
@RequestMapping("/tiposHabitacion")
public class TipoHabitacionController {
    
    @Autowired
    private TipoHabitacionApplicationService tipoHabitacionApplicationService;

    @PostMapping("")
    public ResponseEntity<TipoHabitacionResponseDto> insertarTipoHabitacion(
        @RequestBody TipoHabitacionRequestDto requestDto) {
            try {
                TipoHabitacionResponseDto responseDto = tipoHabitacionApplicationService.insertarTipoHabitacion(requestDto);
                return ResponseEntity.ok(responseDto);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }

    @GetMapping("")
    public ResponseEntity<List<TipoHabitacion>> listarTipoHabitacion(){
        return ResponseEntity.ok(tipoHabitacionApplicationService.listarTipoHabitacion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacion> obtenerTipoHabitacion(@PathVariable Integer id) {
        Optional<TipoHabitacion> tipoHabitacion = tipoHabitacionApplicationService.obtenerTipoHabitacionPorId(id);
        return tipoHabitacion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoHabitacion> actualizarTipoHabitacion(@PathVariable Integer id, @RequestBody TipoHabitacion tipoHabitacion) {
        tipoHabitacion.setIdTipoHabitacion(id);
        TipoHabitacion updated = tipoHabitacionApplicationService.actualizarTipoHabitacion(tipoHabitacion);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarTipoHabitacon(@PathVariable Integer id) {
        if (tipoHabitacionApplicationService.eliminarTipoHabitacion(id)) {
            return ResponseEntity.ok("Tipo de Habitacion eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }
}
