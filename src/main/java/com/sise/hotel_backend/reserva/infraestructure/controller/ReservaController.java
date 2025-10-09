package com.sise.hotel_backend.reserva.infraestructure.controller;

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
import com.sise.hotel_backend.reserva.application.dto.request.ActualizarReservaRequestDto;
import com.sise.hotel_backend.reserva.application.dto.request.InsertarReservaRequestDto;
import com.sise.hotel_backend.reserva.application.dto.response.ActualizarReservaResponseDto;
import com.sise.hotel_backend.reserva.application.dto.response.EliminarReservaResponseDto;
import com.sise.hotel_backend.reserva.application.dto.response.InsertarReservaResponseDto;
import com.sise.hotel_backend.reserva.application.dto.response.ListarReservaResponseDto;
import com.sise.hotel_backend.reserva.application.dto.response.ObtenerReservaResponseDto;
import com.sise.hotel_backend.reserva.application.service.ReservaApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservas")
@Tag(name = "Reservas", description = "Operaciones relacionadas con la gestión de Reservas")
public class ReservaController {

    @Autowired
    private ReservaApplicationService reservaApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear una nueva reserva", 
                description = "Permite insertar una nueva reserva en el sistema")
    public ResponseEntity<BaseResponseDto> insertarReserva(
        @Valid @RequestBody InsertarReservaRequestDto requestDto) {
        try {
            InsertarReservaResponseDto responseDto = 
                    reservaApplicationService.insertarReserva(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    @Operation(summary = "Listar todas las reservas", 
                description = "Obtiene una lista con todas las reservas registradas")
    public ResponseEntity<BaseResponseDto> listarReserva() {
        try {
            List<ListarReservaResponseDto> responseDto =
                    reservaApplicationService.listarReserva();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener reserva por ID", 
                description = "Devuelve la información de una reserva específica según su ID")
    public ResponseEntity<BaseResponseDto> obtenerReserva(@PathVariable Integer id) {
        try {
            ObtenerReservaResponseDto responseDto =
                    reservaApplicationService.obtenerReserva(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una reserva", 
                description = "Actualiza la información de una reserva existente")
    public ResponseEntity<BaseResponseDto> actualizarReserva(@PathVariable Integer id,
        @Valid @RequestBody ActualizarReservaRequestDto requestDto) {
        try {
            ActualizarReservaResponseDto responseDto = 
                    reservaApplicationService.actualizarReserva(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una reserva", 
                description = "Elimina una reserva del sistema según su ID")
    public ResponseEntity<BaseResponseDto> eliminarReserva(@PathVariable Integer id) {
        try {
            EliminarReservaResponseDto responseDto = 
            reservaApplicationService.darBajaReserva(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
