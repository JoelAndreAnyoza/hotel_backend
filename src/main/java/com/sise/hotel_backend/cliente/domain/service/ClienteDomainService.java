package com.sise.hotel_backend.cliente.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.cliente.domain.entities.Cliente;
import com.sise.hotel_backend.cliente.domain.repository.ClienteRepository;

@Service
public class ClienteDomainService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente insertarCliente(Cliente cliente) {
        Cliente newCliente = clienteRepository.saveAndFlush(cliente);
        return clienteRepository.findById(newCliente.getIdCliente()).orElse(null);
    }
    
}
