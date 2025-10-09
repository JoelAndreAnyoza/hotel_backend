package com.sise.hotel_backend.estadosReserva.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.hotel_backend.common.dto.response.BaseResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.request.ActualizarEstadoReservaRequestDto;
import com.sise.hotel_backend.estadosReserva.application.dto.request.InsertarEstadoReservaRequestDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.ActualizarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.EliminarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.InsertarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.ListarEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.dto.response.ObtenerEstadoReservaResponseDto;
import com.sise.hotel_backend.estadosReserva.application.service.EstadoReservaApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estadosReserva")
@Tag(name = "Estados de Reserva", description = "Operaciones relacionadas con la gestión de estados de reserva")
public class EstadoReservaController {
    @Autowired
    private EstadoReservaApplicationService estadoReservaApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear un nuevo estado de reserva", 
                description = "Permite insertar un nuevo estado de reserva en el sistema")
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
    @Operation(summary = "Listar todos los estados de reserva", 
                description = "Obtiene una lista con todos los estados de reserva registrados")
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
    @Operation(summary = "Obtener estado de reserva por ID", 
                description = "Devuelve la información de un estado de reserva específico según su ID")
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
    @Operation(summary = "Actualizar un estado reserva", 
                description = "Actualiza la información de un estado de reserva existente")
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
    @Operation(summary = "Eliminar un estado de reserva", 
                description = "Elimina un estado de reserva del sistema según su ID")
    public ResponseEntity<BaseResponseDto> darBajaEstadoReserva(@PathVariable Integer id) {
        try {
            EliminarEstadoReservaResponseDto responseDto = 
            estadoReservaApplicationService.darBajaEstadoReserva(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
