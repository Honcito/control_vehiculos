package org.hong.control_vehiculos.service;

import org.hong.control_vehiculos.entity.Control_Vehiculos;

import java.time.LocalDateTime;
import java.util.List;

public interface IControlVehiculoService {

    List<Control_Vehiculos> listarControlVehiculos(LocalDateTime fechaLimite);

    Control_Vehiculos actualizarFechaEntrada(Long id);

    Control_Vehiculos guardar(Control_Vehiculos controlVehiculos);

    List<String> findMatriculasByInput(String input);

    Control_Vehiculos buscarControlPorId(Long id);

    void eliminar(Control_Vehiculos controlVehiculos);
}
