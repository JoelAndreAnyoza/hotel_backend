package com.sise.hotel_backend.metodoPago.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sise.hotel_backend.metodoPago.application.dto.request.MetodoPagoRequestDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.MetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.service.MetodoPagoApplicationService;
import com.sise.hotel_backend.metodoPago.domain.entities.MetodoPago;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/metodosPago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoApplicationService metodoPagoApplicationService;

    @PostMapping("")
    public ResponseEntity<MetodoPagoResponseDto> insertarMetdoPago(@RequestBody MetodoPagoRequestDto requestDto) {
        try {
            MetodoPagoResponseDto responseDto = metodoPagoApplicationService.insertarMetodoPago(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<MetodoPago>> listarMetodosPago() {
        return ResponseEntity.ok(metodoPagoApplicationService.listarMetodosPago());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> obtenerMetodoPagoPorId(@PathVariable Integer id) {
        Optional<MetodoPago> metodoPago = metodoPagoApplicationService.obtenerMetodoPagoPorId(id);
        return metodoPago.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> actualizarMetodoPago(@PathVariable Integer id,
            @RequestBody MetodoPago metodoPago) {
        try {
            metodoPago.setIdMetodoPago(id);
            MetodoPago updated = metodoPagoApplicationService.actualizarMetodoPago(metodoPago);
            if (updated != null) {
                return ResponseEntity.ok(updated);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMetodoPago(@PathVariable Integer id) {
        if (metodoPagoApplicationService.eliminarMetodoPago(id)) {
            return ResponseEntity.ok("metodo de pago eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }
}
