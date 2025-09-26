package com.sise.hotel_backend.usuario.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.hotel_backend.usuario.domain.entities.Usuario;
import com.sise.hotel_backend.usuario.domain.repository.UsuarioRepository;

@Service
public class UsuarioDomainService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario insertarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            throw new IllegalArgumentException("El username ya está registrado");
        }
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }
        if (usuarioRepository.existsByNroDocumento(usuario.getNroDocumento())) {
            throw new IllegalArgumentException("El número de documento ya está registrado");
        }
        Usuario newUsuario = usuarioRepository.saveAndFlush(usuario);
        return usuarioRepository.findById(newUsuario.getIdUsuario()).orElse(null);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Integer id) {
        if (usuarioRepository.existsById(id)) {
            return usuarioRepository.findById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public Usuario actualizarUsuario(Integer id,Usuario usuario){
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            throw new IllegalArgumentException("El username ya está registrado");
        }
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }
        if (usuarioRepository.existsByNroDocumento(usuario.getNroDocumento())) {
            throw new IllegalArgumentException("El número de documento ya está registrado");
        }
        usuario.setIdUsuario(id);
        return usuarioRepository.saveAndFlush(usuario);
    }

    public void eliminarUsuario(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }
}
