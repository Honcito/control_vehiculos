package org.hong.control_vehiculos.service;

import org.hong.control_vehiculos.entity.Control_Vehiculos;
import org.hong.control_vehiculos.repository.ControlVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ControlVehiculoServiceImpl implements IControlVehiculoService {

    @Autowired
    private ControlVehiculoRepository controlVehiculoRepository;

    @Override
    public List<Control_Vehiculos> listarControlVehiculos(LocalDateTime fechaLimite) {
        // Implementación para listar controles de vehículos dentro del límite de fecha
        return controlVehiculoRepository.findRecentEntries(fechaLimite);
    }

    @Transactional
    public Control_Vehiculos guardar(Control_Vehiculos controlVehiculos) {
        // Implementación para guardar un nuevo control de vehículos
        System.out.println("Guardando control de vehículo con ID: " + controlVehiculos.getCod_control());
        return controlVehiculoRepository.save(controlVehiculos);
    }

    @Override
    @Transactional
    public Control_Vehiculos actualizarFechaEntrada(Long id) {
        // Implementación para actualizar la fecha y hora de entrada de un control de vehículos
        Optional<Control_Vehiculos> optionalControl = controlVehiculoRepository.findById(id);
        if (optionalControl.isPresent()) {
            Control_Vehiculos controlVehiculo = optionalControl.get();
            controlVehiculo.setFecha_entrada(LocalDateTime.now()); // Asignar fecha y hora de entrada actual
            return controlVehiculoRepository.save(controlVehiculo);
        } else {
            throw new RuntimeException("No se encontró el control de vehículos con id: " + id);
        }
    }

    @Override
    public List<String> findMatriculasByInput(String input) {
        // Implementación para buscar matrículas
        return controlVehiculoRepository.findMatriculasByInput(input);
    }

    @Override
    public Control_Vehiculos buscarControlPorId(Long id) {
        return controlVehiculoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Control_Vehiculos controlVehiculos) {
        controlVehiculoRepository.delete(controlVehiculos);
    }
}
