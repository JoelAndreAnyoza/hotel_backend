package com.sise.hotel_backend.cliente.infraestructure.controller;

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

import com.sise.hotel_backend.cliente.application.dto.request.InsertarClienteRequestDto;
import com.sise.hotel_backend.cliente.application.dto.response.InsertarClienteResponseDto;
import com.sise.hotel_backend.cliente.application.service.ClienteApplicationService;
import com.sise.hotel_backend.cliente.domain.entities.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteApplicationService clienteApplicationService;

    @PostMapping("")
    public ResponseEntity<InsertarClienteResponseDto> insertarCliente(
        @RequestBody InsertarClienteRequestDto requestDto) {
            try {
                InsertarClienteResponseDto responseDto = clienteApplicationService.insertarCliente(requestDto);
                return ResponseEntity.ok(responseDto);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }

    @GetMapping("")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteApplicationService.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteApplicationService.obtenerClientePorId(id);
        return cliente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        cliente.setIdCliente(id);
        Cliente updated = clienteApplicationService.actualizarCliente(cliente);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Integer id) {
        if (clienteApplicationService.eliminarCliente(id)) {
            return ResponseEntity.ok("Proyecto eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }
}
