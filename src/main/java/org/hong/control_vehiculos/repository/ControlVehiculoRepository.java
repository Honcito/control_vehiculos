package org.hong.control_vehiculos.repository;

import org.hong.control_vehiculos.entity.Control_Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ControlVehiculoRepository extends JpaRepository<Control_Vehiculos, Long> {

    @Query("SELECT c FROM Control_Vehiculos c WHERE c.fecha_entrada > :fecha OR c.fecha_salida > :fecha")
    List<Control_Vehiculos> findRecentEntries(@Param("fecha") LocalDateTime fecha);

    List<Control_Vehiculos> findAll();

    @Query("SELECT v.matricula FROM Vehiculo v WHERE v.matricula LIKE %:input%")
    List<String> findMatriculasByInput(@Param("input") String input);
}
