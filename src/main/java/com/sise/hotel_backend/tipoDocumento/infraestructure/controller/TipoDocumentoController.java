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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tiposDocumento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoApplicationService tipoDocumentoApplicationService;

    @PostMapping("")
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
    public ResponseEntity<BaseResponseDto> eliminarTipoDocumento(@PathVariable Integer id) {
        try {
            EliminarTipoDocumentoResponseDto responseDto = 
            tipoDocumentoApplicationService.eliminarTipoDocumento(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }    
}
