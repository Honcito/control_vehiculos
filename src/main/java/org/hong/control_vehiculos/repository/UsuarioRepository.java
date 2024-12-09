package org.hong.control_vehiculos.repository;

import org.hong.control_vehiculos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNombre(String nombre);
}
