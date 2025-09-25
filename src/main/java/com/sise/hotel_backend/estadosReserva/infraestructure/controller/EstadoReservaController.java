package com.sise.hotel_backend.estadosReserva.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sise.hotel_backend.common.dto.response.BaseResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.request.ActualizarEstadoReservaRequestDto;
import com.sise.hotel_backend.estadosReserva.application.dto.request.InsertarEstadoReservaRequestDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.ActualizarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.EliminarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.InsertarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.ListarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.ObtenerEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.service.EstadoReservaApplicationService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/estadosReserva")
public class EstadoReservaController {
    @Autowired
    private EstadoReservaApplicationService estadoReservaApplicationService;

    @PostMapping("")
    public ResponseEntity<BaseResponseDto> insertarEstadoReserva(
        @Valid @RequestBody InsertarEstadoReservaRequestDto requestDto) {
        try {
            InsertarEstadoReservaResponseDto responseDto = 
            estadoReservaApplicationService.insertarEstadoReserva(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    public ResponseEntity<BaseResponseDto> listarEstadosReserva() {
        try {
            List<ListarEstadoReservaResponseDto> responseDto =
            estadoReservaApplicationService.listarEstadoReserva();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseDto> obtenerEstadoReservaPorId(@PathVariable Integer id) {
        try {
            ObtenerEstadoReservaResponseDto responseDto =
            estadoReservaApplicationService.obtenerEstadoReservaPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDto> actualizarEstadoReserva(@PathVariable Integer id, 
    @Valid @RequestBody ActualizarEstadoReservaRequestDto requestDto) {
        try {
            ActualizarEstadoReservaResponseDto responseDto = 
            estadoReservaApplicationService.actualizarEstadoReserva(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDto> eliminarEstadoReserva(@PathVariable Integer id) {
        try {
            EliminarEstadoReservaResponseDto responseDto = 
            estadoReservaApplicationService.eliminarEstadoReserva(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
