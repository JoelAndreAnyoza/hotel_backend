package com.sise.hotel_backend.habitacion.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sise.hotel_backend.common.dto.response.BaseResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.request.ActualizarHabitacionRequestDto;
import com.sise.hotel_backend.habitacion.application.dto.request.InsertarHabitacionRequestDto;
import com.sise.hotel_backend.habitacion.application.dto.response.ActualizarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.EliminarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.InsertarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.ListarHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.dto.response.ObtenerHabitacionResponseDto;
import com.sise.hotel_backend.habitacion.application.service.HabitacionApplicationService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {
    @Autowired
    private HabitacionApplicationService habitacionApplicationService;

    @PostMapping("")
    public ResponseEntity<BaseResponseDto> insertarHabitacion(
        @Valid @RequestBody InsertarHabitacionRequestDto requestDto) {
        try {
            InsertarHabitacionResponseDto responseDto = 
            habitacionApplicationService.insertarHabitacion(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    public ResponseEntity<BaseResponseDto> listarHabitaciones() {
        try {
            List<ListarHabitacionResponseDto> responseDto =
            habitacionApplicationService.listarHabitacion();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }    
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseDto> obtenerHabitacionPorId(@PathVariable Integer id) {
        try {
            ObtenerHabitacionResponseDto responseDto = 
            habitacionApplicationService.obtenerHabitacionPorId(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDto> actualizarHabitacion(@PathVariable Integer id, 
    @Valid @RequestBody ActualizarHabitacionRequestDto requestDto) {
        try {
            ActualizarHabitacionResponseDto responseDto = 
            habitacionApplicationService.actualizarHabitacion(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDto> eliminarHabitacion(@PathVariable Integer id) {
        try {
            EliminarHabitacionResponseDto responseDto = 
            habitacionApplicationService.eliminarHabitacion(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
