package com.sise.hotel_backend.pago.infraestructure.controller;

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
import com.sise.hotel_backend.pago.application.dto.request.ActualizarPagoRequestDto;
import com.sise.hotel_backend.pago.application.dto.request.InsertarPagoRequestDto;
import com.sise.hotel_backend.pago.application.dto.response.ActualizarPagoResponseDto;
import com.sise.hotel_backend.pago.application.dto.response.EliminarPagoResponseDto;
import com.sise.hotel_backend.pago.application.dto.response.InsertarPagoResponseDto;
import com.sise.hotel_backend.pago.application.dto.response.ListarPagoResponseDto;
import com.sise.hotel_backend.pago.application.dto.response.ObtenerPagoResponseDto;
import com.sise.hotel_backend.pago.application.service.PagoApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pagos")
@Tag(name = "Pagos", description = "Operaciones relacionadas con la gestión de pagos")
public class PagoController {

    @Autowired
    private PagoApplicationService pagoApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear un nuevo pago", 
                description = "Permite insertar un nuevo pago en el sistema")
    public ResponseEntity<BaseResponseDto> insertarPago(
        @Valid @RequestBody InsertarPagoRequestDto requestDto) {
        try {
            InsertarPagoResponseDto responseDto = 
                    pagoApplicationService.insertarPago(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    @Operation(summary = "Listar todos los pagos", 
                description = "Obtiene una lista con todos los pagos registrados")
    public ResponseEntity<BaseResponseDto> listarPago() {
        try {
            List<ListarPagoResponseDto> responseDto =
                    pagoApplicationService.listarPago();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener pago por ID", 
                description = "Devuelve la información de un pago específico según su ID")
    public ResponseEntity<BaseResponseDto> obtenerPagoPorId(@PathVariable Integer id) {
        try {
            ObtenerPagoResponseDto responseDto =
                    pagoApplicationService.obtenerPagoPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un pago", 
                description = "Actualiza la información de un pago existente")
    public ResponseEntity<BaseResponseDto> actualizarPago(@PathVariable Integer id,
        @Valid @RequestBody ActualizarPagoRequestDto requestDto) {
        try {
            ActualizarPagoResponseDto responseDto = 
                    pagoApplicationService.actualizarPago(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un pago", 
                description = "Elimina un pago del sistema según su ID")
    public ResponseEntity<BaseResponseDto> eliminarPago(@PathVariable Integer id) {
        try {
            EliminarPagoResponseDto responseDto = 
                    pagoApplicationService.eliminarPago(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
