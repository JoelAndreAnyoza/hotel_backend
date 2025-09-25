package com.sise.hotel_backend.estadosHabitacion.infraestructure.controller;

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
import com.sise.hotel_backend.estadosHabitacion.application.dto.request.ActualizarEstadoHabitacionRequestDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.request.InsertarEstadoHabitacionRequestDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ActualizarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.EliminarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.InsertarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ListarEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.dto.response.ObtenerEstadoHabitacionResponseDto;
import com.sise.hotel_backend.estadosHabitacion.application.service.EstadoHabitacionApplicationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estadosHabitacion")
public class EstadoHabitacionController {
    
    @Autowired
    private EstadoHabitacionApplicationService estadoHabitacionApplicationService;

    @PostMapping("")
    public ResponseEntity<BaseResponseDto> insertarEstadoHabitacion(
        @Valid @RequestBody InsertarEstadoHabitacionRequestDto requestDto) {
            try {
                InsertarEstadoHabitacionResponseDto responseDto = 
                estadoHabitacionApplicationService.insertarEstadoHabitacion(requestDto);
                return ResponseEntity.ok(BaseResponseDto.success(responseDto));
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
            }
        }

    @GetMapping("")
    public ResponseEntity<BaseResponseDto> listarEstadoHabitacion() {
        try {
            List<ListarEstadoHabitacionResponseDto> responseDto = 
            estadoHabitacionApplicationService.listarEstadoHabitacion();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseDto> obtenerEstadoHabitacion(@PathVariable Integer id) {
        try {
            ObtenerEstadoHabitacionResponseDto responseDto = 
            estadoHabitacionApplicationService.obtenerEstadoHabitacion(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDto> actualizarEstadoHabitacion(@PathVariable Integer id,
        @Valid @RequestBody ActualizarEstadoHabitacionRequestDto requestDto) {
        try {
            ActualizarEstadoHabitacionResponseDto responseDto = 
                estadoHabitacionApplicationService.actualizarEstadoHabitacion(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDto> eliminarEstadoHabitacion(@PathVariable Integer id) {
        try {
            EliminarEstadoHabitacionResponseDto responseDto = 
                estadoHabitacionApplicationService.eliminarEstadoHabitacion(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
