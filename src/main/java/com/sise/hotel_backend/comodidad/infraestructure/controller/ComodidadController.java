package com.sise.hotel_backend.comodidad.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.hotel_backend.common.dto.response.BaseResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.request.ActualizarComodidadRequestDto;
import com.sise.hotel_backend.comodidad.application.dto.request.InsertarComodidadRequestDto;
import com.sise.hotel_backend.comodidad.application.dto.response.ActualizarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.EliminarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.InsertarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.ListarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.ObtenerComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.service.ComodidadApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/comodidades")
@Tag(name = "Comodidades", description = "Operaciones relacionadas con la gestión de comodidades")
public class ComodidadController {
    @Autowired
    private ComodidadApplicationService comodidadApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear una nueva comodidad", 
                description = "Permite insertar una nueva comodidad en el sistema")
    public ResponseEntity<BaseResponseDto> insertarComodidad(
        @Valid @RequestBody InsertarComodidadRequestDto requestDto) {
            try {
                InsertarComodidadResponseDto responseDto = 
                comodidadApplicationService.insertarComodidad(requestDto);
                return ResponseEntity.ok(BaseResponseDto.success(responseDto));
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
            }
        }

    @GetMapping("")
    @Operation(summary = "Listar todos las comodidades", 
                description = "Obtiene una lista con todas las comodidades registradas")
    public ResponseEntity<BaseResponseDto> listarComodidades() {
        try {
            List<ListarComodidadResponseDto> responseDto =
            comodidadApplicationService.listarComodidades();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener comodidad por ID", 
                description = "Devuelve la información de una comodidad específica según su ID")
    public ResponseEntity<BaseResponseDto> obtenerComodidadPorId(@PathVariable Integer id) {
        try {
            ObtenerComodidadResponseDto responseDto =
            comodidadApplicationService.obtenerComodidadPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una comodidad", 
                description = "Actualiza la información de una comodidad existente")
    public ResponseEntity<BaseResponseDto> actualizarComodidad(@PathVariable Integer id, 
    @Valid @RequestBody ActualizarComodidadRequestDto requestDto) {
    try {
        ActualizarComodidadResponseDto responseDto = 
        comodidadApplicationService.actualizarComodidad(id, requestDto);
        return ResponseEntity.ok(BaseResponseDto.success(responseDto));
    } catch (Exception e) {
        return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
    }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una comodidad", 
                description = "Elimina una comodidad del sistema según su ID")
    public ResponseEntity<BaseResponseDto> eliminarComodidad(@PathVariable Integer id) {
        try {
            EliminarComodidadResponseDto responseDto = 
            comodidadApplicationService.eliminarComodidad(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));  
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
