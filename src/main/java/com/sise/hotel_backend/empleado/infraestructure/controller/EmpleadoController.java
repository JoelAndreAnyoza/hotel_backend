package com.sise.hotel_backend.empleado.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.hotel_backend.empleado.application.dto.request.InsertarEmpleadoRequestDto;
import com.sise.hotel_backend.empleado.application.dto.response.InsertarEmpleadoResponseDto;
import com.sise.hotel_backend.empleado.application.service.EmpleadoApplicationService;
import com.sise.hotel_backend.empleado.domain.entities.Empleado;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoApplicationService empleadoApplicationService;

    @PostMapping("")
    public ResponseEntity<InsertarEmpleadoResponseDto> insertarEmpleado(
        @RequestBody InsertarEmpleadoRequestDto requestDto){
            try {
                InsertarEmpleadoResponseDto responseDto = empleadoApplicationService.insertarEmpleado(requestDto);
                return ResponseEntity.ok(responseDto);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }
    
    @GetMapping("")
    public ResponseEntity<List<Empleado>> listarEmpleados(){
        return ResponseEntity.ok(empleadoApplicationService.listarEmpleados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Integer id) {
        Optional<Empleado> empleado = empleadoApplicationService.obtenerEmpleadoPorId(id);
        return empleado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado) {
        empleado.setIdEmpleado(id);
        Empleado updated = empleadoApplicationService.actualizarEmpleado(empleado);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable Integer id) {
        if (empleadoApplicationService.eliminarEmpleado(id)) {
            return ResponseEntity.ok("Proyecto eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }
}
