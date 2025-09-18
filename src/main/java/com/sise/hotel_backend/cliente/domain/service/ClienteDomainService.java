package com.sise.hotel_backend.cliente.domain.service;

import java.util.List;
import java.util.Optional;

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
    
    public Optional<Cliente> obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente actualizarCliente(Cliente cliente) {
        if (clienteRepository.existsById(cliente.getIdCliente())) {
            return clienteRepository.saveAndFlush(cliente);
        }
        return null;
    }

    public boolean eliminarCliente(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
