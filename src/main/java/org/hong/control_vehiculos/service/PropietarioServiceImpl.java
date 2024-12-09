package org.hong.control_vehiculos.service;

import org.hong.control_vehiculos.entity.Propietario;
import org.hong.control_vehiculos.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

    @Autowired
    PropietarioRepository propietarioRepository;

    @Override
    public List<Propietario> listarPropietarios() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario buscarPropietarioPorId(Long id) {
        return propietarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarPropietario(Long id) {
        propietarioRepository.deleteById(id);
    }

    @Override
    public void guardarPropietario(Propietario propietario) {
        propietarioRepository.save(propietario);
    }

    @Override
    public Propietario buscarPropietarioPorNombre(String nombre) {
        return propietarioRepository.findByNombre(nombre);
    }

    @Override
    public Long buscarIdPropietarioPorNombre(String nombre) {
        Propietario propietario = propietarioRepository.findByNombre(nombre);
        if (propietario != null) {
            return propietario.getId_propietario();
        } else {
            return null;
        }
    }
}
