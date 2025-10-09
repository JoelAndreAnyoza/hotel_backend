package com.sise.hotel_backend.estadosHabitacion.infraestructure.controller;

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
import com.sise.hotel_backend.estadosHabitacion.application.dto.request.ActualizarEstadoHabitacionRequestDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.request.InsertarEstadoHabitacionRequestDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ActualizarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.EliminarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.InsertarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ListarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ObtenerEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.service.EstadoHabitacionApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estadosHabitacion")
@Tag(name = "Estados de habitacion", description = "Operaciones relacionadas con la gestión de estados de habitacion")
public class EstadoHabitacionController {
    
    @Autowired
    private EstadoHabitacionApplicationService estadoHabitacionApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear un nuevo estado de habitacion", 
                description = "Permite insertar un nuevo estado de habitacion en el sistema")
    public ResponseEntity<BaseResponseDto> insertarEstadoHabitacion(
        @Valid @RequestBody InsertarEstadoHabitacionRequestDto requestDto) {
            try {
                InsertarEstadoHabitacionResponseDto responseDto = 
                estadoHabitacionApplicationService.insertarEstadoHabitacion(requestDto);
                return ResponseEntity.ok(BaseResponseDto.success(responseDto));
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
            }
        }

    @GetMapping("")
    @Operation(summary = "Listar todos los estados de habitacion", 
                description = "Obtiene una lista con todos los estados de habitacion registrados")
    public ResponseEntity<BaseResponseDto> listarEstadoHabitacion() {
        try {
            List<ListarEstadoHabitacionResponseDto> responseDto = 
            estadoHabitacionApplicationService.listarEstadoHabitacion();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener estado de habitacion por ID", 
                description = "Devuelve la información de un estado de habitacion específico según su ID")
    public ResponseEntity<BaseResponseDto> obtenerEstadoHabitacion(@PathVariable Integer id) {
        try {
            ObtenerEstadoHabitacionResponseDto responseDto = 
            estadoHabitacionApplicationService.obtenerEstadoHabitacion(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un estado de habitacion", 
                description = "Actualiza la información de un estado de habitacion existente")
    public ResponseEntity<BaseResponseDto> actualizarEstadoHabitacion(@PathVariable Integer id,
        @Valid @RequestBody ActualizarEstadoHabitacionRequestDto requestDto) {
        try {
            ActualizarEstadoHabitacionResponseDto responseDto = 
                estadoHabitacionApplicationService.actualizarEstadoHabitacion(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un estado de habitacion", 
                description = "Elimina un estado de habitacion del sistema según su ID")
    public ResponseEntity<BaseResponseDto> eliminarEstadoHabitacion(@PathVariable Integer id) {
        try {
            EliminarEstadoHabitacionResponseDto responseDto = 
                estadoHabitacionApplicationService.eliminarEstadoHabitacion(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
