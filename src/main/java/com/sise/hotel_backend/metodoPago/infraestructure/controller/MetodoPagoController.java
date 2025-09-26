package com.sise.hotel_backend.metodoPago.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.hotel_backend.common.dto.response.BaseResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.request.ActualizarMetodoPagoRequestDto;
import com.sise.hotel_backend.metodoPago.application.dto.request.InsertarMetodoPagoRequestDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.ActualizarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.EliminarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.InsertarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.ListarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.ObtenerMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.service.MetodoPagoApplicationService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/metodosPago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoApplicationService metodoPagoApplicationService;

    @PostMapping("")
    public ResponseEntity<BaseResponseDto> insertarMetdoPago(
        @Valid @RequestBody InsertarMetodoPagoRequestDto requestDto) {
        try {
            InsertarMetodoPagoResponseDto responseDto = 
            metodoPagoApplicationService.insertarMetodoPago(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    public ResponseEntity<BaseResponseDto> listarMetodosPago() {
        try {
            List<ListarMetodoPagoResponseDto> responseDto =
            metodoPagoApplicationService.listarMetodosPago();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseDto> obtenerMetodoPagoPorId(@PathVariable Integer id) {
        try {
            ObtenerMetodoPagoResponseDto responseDto =
            metodoPagoApplicationService.obtenerMetodoPagoPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDto> actualizarMetodoPago(@PathVariable Integer id,
        @Valid @RequestBody ActualizarMetodoPagoRequestDto requestDto) {
        try {
            ActualizarMetodoPagoResponseDto responseDto = 
            metodoPagoApplicationService.actualizarMetodoPago(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDto> eliminarMetodoPago(@PathVariable Integer id) {
        try {
            EliminarMetodoPagoResponseDto responseDto = 
            metodoPagoApplicationService.eliminarMetodoPago(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
