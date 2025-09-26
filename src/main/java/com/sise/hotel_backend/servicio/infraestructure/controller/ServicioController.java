package com.sise.hotel_backend.servicio.infraestructure.controller;

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
import com.sise.hotel_backend.servicio.application.dto.request.ActualizarServicioRequestDto;
import com.sise.hotel_backend.servicio.application.dto.request.InsertarServicioRequestDto;
import com.sise.hotel_backend.servicio.application.dto.response.ActualizarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.EliminarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.InsertarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.ListarServicioResponseDto;
import com.sise.hotel_backend.servicio.application.dto.response.ObtenerServicioResponseDto;

import jakarta.validation.Valid;

import com.sise.hotel_backend.servicio.application.service.ServicioApplicationService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
    @Autowired
    private ServicioApplicationService servicioApplicationService;

    @PostMapping("")
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
