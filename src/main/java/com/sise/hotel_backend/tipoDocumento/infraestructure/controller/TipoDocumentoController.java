package com.sise.hotel_backend.tipoDocumento.infraestructure.controller;

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
import com.sise.hotel_backend.tipoDocumento.application.dto.request.ActualizarTipoDocumentoRequestDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.request.InsertarTipoDocumentoRequestDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.ActualizarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.EliminarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.InsertarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.ListarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.ObtenerTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.service.TipoDocumentoApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tiposDocumento")
@Tag(name = "Tipos de Documento", description = "Operaciones relacionadas con la gestión de tipos de documento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoApplicationService tipoDocumentoApplicationService;

    @PostMapping("")
    @Operation(summary = "Crear un nuevo tipo de documento", 
                description = "Permite insertar un nuevo tipo de documento en el sistema")
    public ResponseEntity<BaseResponseDto> insertarTipoDocumento(
        @Valid @RequestBody InsertarTipoDocumentoRequestDto requestDto) {
            try {
                InsertarTipoDocumentoResponseDto responseDto = 
                tipoDocumentoApplicationService.insertarTipoDocumento(requestDto);
                return ResponseEntity.ok(BaseResponseDto.success(responseDto));
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
            }
        }

    @GetMapping("")
    @Operation(summary = "Listar todos los tipos de documento", 
                description = "Obtiene una lista con todos los tipos de documento registrados")
    public ResponseEntity<BaseResponseDto> listarTipoDocumento() {
        try {
            List<ListarTipoDocumentoResponseDto> responseDto =
            tipoDocumentoApplicationService.listarTipoDocumento();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener tipo de documento por ID", 
                description = "Devuelve la información de un tipo de documento específico según su ID")
    public ResponseEntity<BaseResponseDto> obtenerTipoDocumentoPorId(@PathVariable Integer id) {
        try {
            ObtenerTipoDocumentoResponseDto responseDto =
            tipoDocumentoApplicationService.obtenerTipoDocumentoPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un tipo de documento", 
                description = "Actualiza la información de un tipo de documento existente")
    public ResponseEntity<BaseResponseDto> actualizarTipoDocumento(@PathVariable Integer id, 
    @Valid @RequestBody ActualizarTipoDocumentoRequestDto requestDto) {
        try {
            ActualizarTipoDocumentoResponseDto responseDto = 
            tipoDocumentoApplicationService.actualizarTipoDocumento(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un tipo de documento", 
                description = "Elimina un tipo de documento del sistema según su ID")
    public ResponseEntity<BaseResponseDto> darBajaTipoDocumento(@PathVariable Integer id) {
        try {
            EliminarTipoDocumentoResponseDto responseDto = 
            tipoDocumentoApplicationService.darBajaTipoDocumento(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }    
}
