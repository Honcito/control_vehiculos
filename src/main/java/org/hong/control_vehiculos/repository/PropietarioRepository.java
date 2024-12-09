package org.hong.control_vehiculos.repository;


import org.hong.control_vehiculos.entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {

    Propietario findByNombre(String nombre);


}
