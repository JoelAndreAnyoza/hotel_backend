package com.sise.hotel_backend.servicio.infraestructure.controller;

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
import com.sise.hotel_backend.servicio.application.dto.request.ActualizarServicioRequestDto;
import com.sise.hotel_backend.servicio.application.dto.request.InsertarServicioRequestDto;
import com.sise.hotel_backend.servicio.application.dto.response.ActualizarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.EliminarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.InsertarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.ListarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.ObtenerServicioResponseDto;

import jakarta.validation.Valid;

import com.sise.hotel_backend.servicio.application.service.ServicioApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/servicios")
@Tag(name = "Servicios", description = "Operaciones relacionadas con la gestión de servicios")
public class ServicioController {
    @Autowired
    private ServicioApplicationService servicioApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear un nuevo servicio", 
                description = "Permite insertar un nuevo servicio al sistema")
    public ResponseEntity<BaseResponseDto> insertarServicio(
        @Valid @RequestBody InsertarServicioRequestDto requestDto) {
        try {
            InsertarServicioResponseDto responseDto = 
            servicioApplicationService.insertarServicio(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    @Operation(summary = "Listar todos los servicios", 
    description = "Obtiene una lista con todos los servicios registrados")
    public ResponseEntity<BaseResponseDto> listarServicios() {
        try {
            List<ListarServicioResponseDto> responseDto =
            servicioApplicationService.listarServicios();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener servicio por ID", 
                description = "Devuelve la información de un servicio específico según su ID")
    public ResponseEntity<BaseResponseDto> obtenerServicioPorId(@PathVariable Integer id) {
        try {
            ObtenerServicioResponseDto responseDto =
            servicioApplicationService.obtenerServicioPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un servicio", 
                description = "Actualiza la información de un servicio existente")
    public ResponseEntity<BaseResponseDto> actualizarServicio(@PathVariable Integer id,
        @Valid @RequestBody ActualizarServicioRequestDto requestDto) {
        try {
            ActualizarServicioResponseDto responseDto = 
            servicioApplicationService.actualizarServicio(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un servicio", 
    description = "Elimina un servicio del sistema según su ID")
    public ResponseEntity<BaseResponseDto> eliminarServicio(@PathVariable Integer id) {
        try {
            EliminarServicioResponseDto responseDto = 
            servicioApplicationService.eliminarServicio(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
