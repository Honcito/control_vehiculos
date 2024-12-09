package org.hong.control_vehiculos.service;

import org.hong.control_vehiculos.entity.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    List<Vehiculo> listarVehiculos();

    Vehiculo buscarVehiculoPorId(Long id);

    void guardarVehiculo(Vehiculo vehiculo);

    void eliminarVehiculo(Long id);

    Vehiculo buscarVehiculoPorMatricula(String matricula);

    Long buscarIdVehiculoPorMatricula(String matricula);


    List<String> obtenerMatriculas(String input);
}
