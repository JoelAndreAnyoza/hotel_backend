package com.sise.hotel_backend.servicio.infraestructure.controller;

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

import com.sise.hotel_backend.servicio.application.dto.request.ServicioRequestDto;
import com.sise.hotel_backend.servicio.application.dto.response.ServicioResponseDto;
import com.sise.hotel_backend.servicio.domain.entities.Servicio;
import com.sise.hotel_backend.servicio.application.service.ServicioApplicationService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
    @Autowired
    private ServicioApplicationService servicioApplicationService;

    @PostMapping("")
    public ResponseEntity<ServicioResponseDto> insertarServicio(@RequestBody ServicioRequestDto requestDto) {
        try {
            ServicioResponseDto responseDto = servicioApplicationService.insertarServicio(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Servicio>> listarServicios() {
        return ResponseEntity.ok(servicioApplicationService.listarServicios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> obtenerServicioPorId(@PathVariable Integer id) {
        Optional<Servicio> servicio = servicioApplicationService.obtenerServicioPorId(id);
        return servicio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> actualizarServicio(@PathVariable Integer id,
            @RequestBody Servicio servicio) {
        try {
            servicio.setIdServicio(id);
            Servicio updated = servicioApplicationService.actualizarServicio(servicio);
            if (updated != null) {
                return ResponseEntity.ok(updated);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarServicio(@PathVariable Integer id) {
        if (servicioApplicationService.eliminarServicio(id)) {
            return ResponseEntity.ok("servicio eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }
}
