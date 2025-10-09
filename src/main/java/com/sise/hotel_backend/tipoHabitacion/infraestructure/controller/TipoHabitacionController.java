package com.sise.hotel_backend.tipoHabitacion.infraestructure.controller;

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
import com.sise.hotel_backend.tipoHabitacion.application.dto.request.ActualizarTipoHabitacionRequestDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.request.InsertarTipoHabitacionRequestDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.ActualizarTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.EliminarTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.InsertarTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.ListarTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.dto.response.ObtenerTipoHabitacionResponseDto;
import com.sise.hotel_backend.tipoHabitacion.application.service.TipoHabitacionApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tiposHabitacion")
@Tag(name = "Tipos de Habitacion", 
    description = "Operaciones relacionadas con la gestión de tipos de habitacion")
public class TipoHabitacionController {
    
    @Autowired
    private TipoHabitacionApplicationService tipoHabitacionApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear un nuevo tipo de habitacion", 
                description = "Permite insertar un nuevo tipo de habitacion en el sistema")
    public ResponseEntity<BaseResponseDto> insertarTipoHabitacion(
        @Valid @RequestBody InsertarTipoHabitacionRequestDto requestDto) {
            try {
                InsertarTipoHabitacionResponseDto responseDto = 
                tipoHabitacionApplicationService.insertarTipoHabitacion(requestDto);
                return ResponseEntity.ok(BaseResponseDto.success(responseDto));
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
            }
        }

    @GetMapping("")
    @Operation(summary = "Listar todos los tipos de habitacion", 
                description = "Obtiene una lista con todos los tipos de habitacion registrados")
    public ResponseEntity<BaseResponseDto> listarTipoHabitacion(){
        try {
            List<ListarTipoHabitacionResponseDto> responseDto =
            tipoHabitacionApplicationService.listarTipoHabitacion();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener tipo de habitacion por ID", 
                description = "Devuelve la información de un tipo de habitacion específico según su ID")
    public ResponseEntity<BaseResponseDto> obtenerTipoHabitacion(@PathVariable Integer id) {
        try {
            ObtenerTipoHabitacionResponseDto responseDto =
            tipoHabitacionApplicationService.obtenerTipoHabitacionPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un tipo de habitacion", 
    description = "Actualiza la información de un tipo de habitacion existente")
    public ResponseEntity<BaseResponseDto> actualizarTipoHabitacion(@PathVariable Integer id, 
    @Valid @RequestBody ActualizarTipoHabitacionRequestDto requestDto) {
        try {
            ActualizarTipoHabitacionResponseDto responseDto = 
            tipoHabitacionApplicationService.actualizarTipoHabitacion(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Eliminar un tipo de habitacion", 
    description = "Elimina un tipo de habitacion del sistema según su ID")
    public ResponseEntity<BaseResponseDto> eliminarTipoHabitacon(@PathVariable Integer id) {
        try {
            EliminarTipoHabitacionResponseDto responseDto = 
            tipoHabitacionApplicationService.darBajaTipoHabitacion(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
