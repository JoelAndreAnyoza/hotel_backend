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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tiposHabitacion")
public class TipoHabitacionController {
    
    @Autowired
    private TipoHabitacionApplicationService tipoHabitacionApplicationService;

    @PostMapping("")
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
    public ResponseEntity<BaseResponseDto> eliminarTipoHabitacon(@PathVariable Integer id) {
        try {
            EliminarTipoHabitacionResponseDto responseDto = 
            tipoHabitacionApplicationService.eliminarTipoHabitacion(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
