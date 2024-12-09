package org.hong.control_vehiculos.service;

import org.hong.control_vehiculos.entity.Vehiculo;
import org.hong.control_vehiculos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> listarVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo buscarVehiculoPorId(Long id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

    @Override
    public void eliminarVehiculo(Long id) {
        vehiculoRepository.deleteById(id);
    }

    @Override
    public Vehiculo buscarVehiculoPorMatricula(String matricula) {
        return vehiculoRepository.findVehiculoByMatricula(matricula);
    }

    @Override
    public Long buscarIdVehiculoPorMatricula(String matricula) {
        Vehiculo vehiculo = vehiculoRepository.findIdVehiculoByMatricula(matricula);
        if (vehiculo != null) {
            return vehiculo.getCod_vehiculo();
        } else {
            return null;
        }
    }

    @Override
    public List<String> obtenerMatriculas(String input) {
        return vehiculoRepository.findMatriculasByInput(input);
    }
}
