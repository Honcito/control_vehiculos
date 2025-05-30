package org.hong.control_vehiculos.config;

import lombok.Getter;
import org.hong.control_vehiculos.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserInfoDetails implements UserDetails {

    @Getter
    private Long id;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoDetails(Usuario usuario) {
        this.id = usuario.getId_usuario();
        this.username = usuario.getNombre();
        this.password = usuario.getPassword();
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority(usuario.getRol().name()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
