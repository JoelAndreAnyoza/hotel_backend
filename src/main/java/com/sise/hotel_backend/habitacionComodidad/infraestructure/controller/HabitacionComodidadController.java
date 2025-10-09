package com.sise.hotel_backend.habitacionComodidad.infraestructure.controller;

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
import com.sise.hotel_backend.habitacionComodidad.application.dto.request.ActualizarHabitacionComodidadRequestDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.request.InsertarHabitacionComodidadRequestDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.ActualizarHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.EliminarHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.InsertarHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.ListarHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.application.dto.response.ObtenerHabitacionComodidadResponseDto;
import com.sise.hotel_backend.habitacionComodidad.application.service.HabitacionComodidadApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/habitacionComodidades")
@Tag(name = "Habitación Comodidad", 
    description = "Gestión de la relación entre habitaciones y comodidades")

public class HabitacionComodidadController {
    
    @Autowired
    private HabitacionComodidadApplicationService habitacionComodidadApplicationService;

    @PostMapping("")
    @Operation(summary = "Insertar relación habitación-comodidad", 
                description = "Crea una nueva asociación entre una habitación y una comodidad")
    public ResponseEntity<BaseResponseDto> insertarHabitacionComodidad(
            @Valid @RequestBody InsertarHabitacionComodidadRequestDto requestDto) {
        try {
            InsertarHabitacionComodidadResponseDto responseDto =
                    habitacionComodidadApplicationService.insertarHabitacionComodidad(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    @Operation(summary = "Listar todas las relaciones habitación-comodidad", 
                description = "Obtiene una lista de todas las relaciones entre habitaciones y comodidades")
    public ResponseEntity<BaseResponseDto> listarHabitacionComodidades() {
        try {
            List<ListarHabitacionComodidadResponseDto> responseDto =
                habitacionComodidadApplicationService.listarHabitacionComodidad();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener relación por ID", 
                description = "Devuelve la relación entre una habitación y una comodidad específica")
    public ResponseEntity<BaseResponseDto> obtenerHabitacionComodidad(@PathVariable Integer id) {
        try {
            ObtenerHabitacionComodidadResponseDto responseDto =
            habitacionComodidadApplicationService.obtenerHabitacionComodidad(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar relación habitación-comodidad", 
                description = "Actualiza la relación existente entre una habitación y una comodidad")
    public ResponseEntity<BaseResponseDto> actualizarHabitacionComodidad(@PathVariable Integer id,
        @Valid @RequestBody ActualizarHabitacionComodidadRequestDto requestDto) {
        try {
            ActualizarHabitacionComodidadResponseDto responseDto =
                habitacionComodidadApplicationService.actualizarHabitacionComodidad(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar relación habitación-comodidad", 
                description = "Elimina la asociación entre una habitación y una comodidad")
    public ResponseEntity<BaseResponseDto> eliminarHabitacionComodidad(@PathVariable Integer id) {
        try {
            EliminarHabitacionComodidadResponseDto responseDto =
            habitacionComodidadApplicationService.darBajaHabitacionComodidad(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
