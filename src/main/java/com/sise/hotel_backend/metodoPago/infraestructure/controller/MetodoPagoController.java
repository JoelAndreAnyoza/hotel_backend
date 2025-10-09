package com.sise.hotel_backend.metodoPago.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.hotel_backend.common.dto.response.BaseResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.request.ActualizarMetodoPagoRequestDto;
import com.sise.hotel_backend.metodoPago.application.dto.request.InsertarMetodoPagoRequestDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.ActualizarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.EliminarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.InsertarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.ListarMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.dto.response.ObtenerMetodoPagoResponseDto;
import com.sise.hotel_backend.metodoPago.application.service.MetodoPagoApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/metodosPago")
@Tag(name = "Metodos de Pago", description = "Operaciones relacionadas con la gestión de metodos de pago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoApplicationService metodoPagoApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear un nuevo metodo de pago", 
                description = "Permite insertar un nuevo metodo de pago en el sistema")
    public ResponseEntity<BaseResponseDto> insertarMetdoPago(
        @Valid @RequestBody InsertarMetodoPagoRequestDto requestDto) {
        try {
            InsertarMetodoPagoResponseDto responseDto = 
            metodoPagoApplicationService.insertarMetodoPago(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    @Operation(summary = "Listar todos los metodos de pago", 
                description = "Obtiene una lista con todos los metodos de pago registrados")
    public ResponseEntity<BaseResponseDto> listarMetodosPago() {
        try {
            List<ListarMetodoPagoResponseDto> responseDto =
            metodoPagoApplicationService.listarMetodosPago();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener metodo de pago por ID", 
                description = "Devuelve la información de un metodo de pago específico según su ID")
    public ResponseEntity<BaseResponseDto> obtenerMetodoPagoPorId(@PathVariable Integer id) {
        try {
            ObtenerMetodoPagoResponseDto responseDto =
            metodoPagoApplicationService.obtenerMetodoPagoPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un metodo de pago", 
                description = "Actualiza la información de un metodo de pago existente")
    public ResponseEntity<BaseResponseDto> actualizarMetodoPago(@PathVariable Integer id,
        @Valid @RequestBody ActualizarMetodoPagoRequestDto requestDto) {
        try {
            ActualizarMetodoPagoResponseDto responseDto = 
            metodoPagoApplicationService.actualizarMetodoPago(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un metodo de pago", 
                description = "Elimina un metodo de pago del sistema según su ID")
    public ResponseEntity<BaseResponseDto> eliminarMetodoPago(@PathVariable Integer id) {
        try {
            EliminarMetodoPagoResponseDto responseDto = 
            metodoPagoApplicationService.eliminarMetodoPago(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
