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
        Usuario newUsuario = usuarioRepository.saveAndFlush(usuario);
        return usuarioRepository.findById(newUsuario.getIdUsuario()).orElse(null);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public Usuario actualizarUsuario(Usuario usuario){
        if (usuarioRepository.existsById(usuario.getIdUsuario())) {
            return usuarioRepository.saveAndFlush(usuario);
        }
        return null;
    }

    public boolean eliminarUsuario(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
