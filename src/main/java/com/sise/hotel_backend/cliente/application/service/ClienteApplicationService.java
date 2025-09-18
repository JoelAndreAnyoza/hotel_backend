package com.sise.hotel_backend.cliente.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.cliente.application.dto.request.InsertarClienteRequestDto;
import com.sise.hotel_backend.cliente.application.dto.response.InsertarClienteResponseDto;
import com.sise.hotel_backend.cliente.application.mapper.InsertarClienteMapper;
import com.sise.hotel_backend.cliente.domain.entities.Cliente;
import com.sise.hotel_backend.cliente.domain.service.ClienteDomainService;

@Service
public class ClienteApplicationService {
    
    @Autowired
    ClienteDomainService clienteDomainService;

    @Autowired
    InsertarClienteMapper insertarClienteMapper;

    public InsertarClienteResponseDto insertarCliente(InsertarClienteRequestDto requestDto){
        Cliente cliente = clienteDomainService.insertarCliente(
            insertarClienteMapper.requestToEntity(requestDto));
        return insertarClienteMapper.entityToResponse(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDomainService.listarClientes();
    }

    public Optional<Cliente> obtenerClientePorId(Integer id) {
        return clienteDomainService.obtenerClientePorId(id);
    }

    public Cliente actualizarCliente(Cliente cliente) {
        return clienteDomainService.actualizarCliente(cliente);
    }

    public boolean eliminarCliente(Integer id) {
        return clienteDomainService.eliminarCliente(id);
    }
}
