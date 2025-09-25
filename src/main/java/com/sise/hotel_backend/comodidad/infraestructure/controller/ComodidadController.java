package com.sise.hotel_backend.comodidad.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sise.hotel_backend.common.dto.response.BaseResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.request.ActualizarComodidadRequestDto;
import com.sise.hotel_backend.comodidad.application.dto.request.InsertarComodidadRequestDto;
import com.sise.hotel_backend.comodidad.application.dto.response.ActualizarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.EliminarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.InsertarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.ListarComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.dto.response.ObtenerComodidadResponseDto;
import com.sise.hotel_backend.comodidad.application.service.ComodidadApplicationService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/comodidades")
public class ComodidadController {
    @Autowired
    private ComodidadApplicationService comodidadApplicationService;

    @PostMapping("")
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
