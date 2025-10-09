package com.sise.hotel_backend.reservaServicio.infraestructure.controller;

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
import com.sise.hotel_backend.reservaServicio.application.dto.request.ActualizarReservaServicioRequestDto;
import com.sise.hotel_backend.reservaServicio.application.dto.request.InsertarReservaServicioRequestDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.ActualizarReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.EliminarReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.InsertarReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.ListarReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.application.dto.response.ObtenerReservaServicioResponseDto;
import com.sise.hotel_backend.reservaServicio.application.service.ReservaServicioApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservasServicio")
@Tag(name = "Reservas de Servicio", 
    description = "Operaciones relacionadas con la gestión de Reservas de servicio")
public class ReservaServicioController {

    @Autowired
    private ReservaServicioApplicationService reservaServicioApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear una nueva reserva de servicio", 
                description = "Permite insertar una nueva reserva de servicio en el sistema")
    public ResponseEntity<BaseResponseDto> insertarReservaServicio(
        @Valid @RequestBody InsertarReservaServicioRequestDto requestDto) {
            try {
                InsertarReservaServicioResponseDto responseDto = 
                        reservaServicioApplicationService.insertarReservaServicio(requestDto);
                return ResponseEntity.ok(BaseResponseDto.success(responseDto));
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
            }
        }

    @GetMapping("")
    @Operation(summary = "Listar todas las reservas de servicio", 
                description = "Obtiene una lista con todas las reservas de servicio registrados")
    public ResponseEntity<BaseResponseDto> listarReservaServicio() {
        try {
            List<ListarReservaServicioResponseDto> responseDto =
                    reservaServicioApplicationService.listarReservaServicios();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener reserva de servicio por ID", 
                description = "Devuelve la información de una reserva de servicio específico según su ID")
    public ResponseEntity<BaseResponseDto> obtenerReservaServicioPorId(@PathVariable Integer id) {
        try {
            ObtenerReservaServicioResponseDto responseDto =
                    reservaServicioApplicationService.obtenerReservaServicioPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una reserva de servicio", 
                description = "Actualiza la información de una reserva de servicio existente")
    public ResponseEntity<BaseResponseDto> actualizarReservaServicio(@PathVariable Integer id, 
    @Valid @RequestBody ActualizarReservaServicioRequestDto requestDto) {
        try {
            ActualizarReservaServicioResponseDto responseDto = 
                    reservaServicioApplicationService.actualizarReservaServicio(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una reserva de servicio", 
                description = "Elimina una reserva de servicio del sistema según su ID")
    public ResponseEntity<BaseResponseDto> darBajaReservaServicio(@PathVariable Integer id) {
        try {
            EliminarReservaServicioResponseDto responseDto = 
                    reservaServicioApplicationService.darBajaReservaServicio(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }   
}
