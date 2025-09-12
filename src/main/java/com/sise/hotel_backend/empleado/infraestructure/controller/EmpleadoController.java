package com.sise.hotel_backend.empleado.infraestructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @PostMapping("")
    public String insertarEmpleado() {
        return "hola desde Spring";
    }
}
