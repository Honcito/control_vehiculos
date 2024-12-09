package org.hong.control_vehiculos.service;

import org.hong.control_vehiculos.entity.Usuario;
import org.hong.control_vehiculos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    @Override
    public Long buscarIdUsuarioPorNombre(String nombre) {
        Usuario usuario = usuarioRepository.findByNombre(nombre);
        if (usuario != null) {
            return usuario.getId_usuario();
        } else {
            return null;
        }
    }
}
