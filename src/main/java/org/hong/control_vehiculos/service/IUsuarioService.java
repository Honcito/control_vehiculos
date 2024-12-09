package org.hong.control_vehiculos.service;

import org.hong.control_vehiculos.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> listarUsuarios();

    Usuario buscarUsuarioPorId(Long id);

    void eliminarUsuario(Long id);

    void guardarUsuario(Usuario usuario);

    Usuario buscarUsuarioPorNombre(String nombre);

    Long buscarIdUsuarioPorNombre(String nombre);
}
