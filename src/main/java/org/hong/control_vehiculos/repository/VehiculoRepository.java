package org.hong.control_vehiculos.repository;

import org.hong.control_vehiculos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    Vehiculo findVehiculoByMatricula(String matricula);

    Vehiculo findIdVehiculoByMatricula(String matricula);

    @Query("SELECT v.matricula FROM Vehiculo v WHERE v.matricula LIKE %:input%")
    List<String> findMatriculasByInput(String input);
}
