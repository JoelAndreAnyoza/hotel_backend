package com.sise.hotel_backend.habitacion.infraestructure.controller;

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
import com.sise.hotel_backend.habitacion.application.dto.request.ActualizarHabitacionRequestDto;
import com.sise.hotel_backend.habitacion.application.dto.request.InsertarHabitacionRequestDto;
import com.sise.hotel_backend.habitacion.application.dto.response.ActualizarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.EliminarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.InsertarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.ListarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.ObtenerHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.service.HabitacionApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/habitaciones")
@Tag(name = "Habitaciones", description = "Operaciones relacionadas con la gestión de habitaciones")
public class HabitacionController {
    @Autowired
    private HabitacionApplicationService habitacionApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear una nueva habitacion", 
                description = "Permite insertar una nueva habitacion en el sistema")
    public ResponseEntity<BaseResponseDto> insertarHabitacion(
        @Valid @RequestBody InsertarHabitacionRequestDto requestDto) {
        try {
            InsertarHabitacionResponseDto responseDto = 
            habitacionApplicationService.insertarHabitacion(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    @Operation(summary = "Listar todas las habitaciones", 
                description = "Obtiene una lista con todas las habitaciones registradas")
    public ResponseEntity<BaseResponseDto> listarHabitaciones() {
        try {
            List<ListarHabitacionResponseDto> responseDto =
            habitacionApplicationService.listarHabitacion();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }    
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener habitacion por ID", 
                description = "Devuelve la información de una habitacion específica según su ID")
    public ResponseEntity<BaseResponseDto> obtenerHabitacionPorId(@PathVariable Integer id) {
        try {
            ObtenerHabitacionResponseDto responseDto = 
            habitacionApplicationService.obtenerHabitacionPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una habitacion", 
                description = "Actualiza la información de una habitacion existente")
    public ResponseEntity<BaseResponseDto> actualizarHabitacion(@PathVariable Integer id, 
    @Valid @RequestBody ActualizarHabitacionRequestDto requestDto) {
        try {
            ActualizarHabitacionResponseDto responseDto = 
            habitacionApplicationService.actualizarHabitacion(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una habitacion", 
                description = "Elimina una habitacion del sistema según su ID")
    public ResponseEntity<BaseResponseDto> darBajaHabitacion(@PathVariable Integer id) {
        try {
            EliminarHabitacionResponseDto responseDto = 
            habitacionApplicationService.darBajaHabitacion(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
