package com.sise.hotel_backend.comodidad.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sise.hotel_backend.comodidad.application.dto.request.ComodidadRequestDto;
import com.sise.hotel_backend.comodidad.application.dto.response.ComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.service.ComodidadApplicationService;
import com.sise.hotel_backend.comodidad.domain.entities.Comodidad;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/comodidades")
public class ComodidadController {
    @Autowired
    private ComodidadApplicationService comodidadApplicationService;

    @PostMapping("")
    public ResponseEntity<ComodidadResponseDto> insertarComodidad(@RequestBody ComodidadRequestDto requestDto) {
        try {
            ComodidadResponseDto responseDto = comodidadApplicationService.insertarComodidad(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Comodidad>> listarComodidades() {
        return ResponseEntity.ok(comodidadApplicationService.listarComodidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comodidad> obtenerComodidadPorId(@PathVariable Integer id) {
        Optional<Comodidad> comodidad = comodidadApplicationService.obtenerComodidadPorId(id);
        return comodidad.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comodidad> actualizarComodidad(@PathVariable Integer id, @RequestBody Comodidad comodidad) {
        comodidad.setIdComodidad(id);
        Comodidad updated = comodidadApplicationService.actualizarComodidad(comodidad);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarComodidad(@PathVariable Integer id) {
        if (comodidadApplicationService.eliminarComodidad(id)) {
            return ResponseEntity.ok("documento eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }
}
