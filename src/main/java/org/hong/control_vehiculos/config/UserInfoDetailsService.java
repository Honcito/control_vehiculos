package org.hong.control_vehiculos.config;

import org.hong.control_vehiculos.entity.Usuario;
import org.hong.control_vehiculos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Configuration
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Optional<Usuario> empleado = Optional.ofNullable(usuarioRepository.findByNombre(nombre));
        return empleado.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("El Empleado no existe"));
    }
}
