package org.hong.control_vehiculos.service;

import org.hong.control_vehiculos.entity.Propietario;

import java.util.List;

public interface IPropietarioService {

    List<Propietario> listarPropietarios();

    Propietario buscarPropietarioPorId(Long id);

    void eliminarPropietario(Long id);

    void guardarPropietario(Propietario propietario);

    Propietario buscarPropietarioPorNombre(String nombre);

    Long buscarIdPropietarioPorNombre(String nombre);
}
