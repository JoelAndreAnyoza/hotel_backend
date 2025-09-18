package com.sise.hotel_backend.cliente.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.hotel_backend.cliente.application.dto.request.InsertarClienteRequestDto;
import com.sise.hotel_backend.cliente.application.dto.response.InsertarClienteResponseDto;
import com.sise.hotel_backend.cliente.domain.entities.Cliente;
import com.sise.hotel_backend.common.application.IEntityDtoMapper;

@Component
public class InsertarClienteMapper 
implements IEntityDtoMapper<Cliente, InsertarClienteRequestDto, InsertarClienteResponseDto>{
    
    @Override
    public Cliente requestToEntity(InsertarClienteRequestDto requestDto) {
        Cliente cliente = new Cliente();
        cliente.setNombres(requestDto.getNombres());
        cliente.setApellidoPaterno(requestDto.getApellidoPaterno());
        cliente.setApellidoMaterno(requestDto.getApellidoMaterno());
        cliente.setTipoDocumento(requestDto.getTipoDocumento());
        cliente.setNumeroDocumento(requestDto.getNumeroDocumento());
        cliente.setEmail(requestDto.getEmail());
        cliente.setTelefono(requestDto.getTelefono());
        cliente.setDireccion(requestDto.getDireccion());
        return cliente;
    }

    @Override
    public InsertarClienteResponseDto entityToResponse(Cliente entity) {
        InsertarClienteResponseDto responseDto = new InsertarClienteResponseDto();
        responseDto.setIdCliente(entity.getIdCliente());
        responseDto.setNombres(entity.getNombres());
        responseDto.setApellidoPaterno(entity.getApellidoPaterno());
        responseDto.setApellidoMaterno(entity.getApellidoMaterno());
        responseDto.setTipoDocumento(entity.getTipoDocumento());
        responseDto.setNumeroDocumento(entity.getNumeroDocumento());
        responseDto.setEmail(entity.getEmail());
        responseDto.setTelefono(entity.getTelefono());
        responseDto.setDireccion(entity.getDireccion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
