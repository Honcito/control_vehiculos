package org.hong.control_vehiculos.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;


@Controller
public class HomeController {

    @GetMapping({"/", "/index", "home"})
    public String index(Authentication authentication) {
        // Obtener los roles del usuario autenticado
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Comprobar si el usuario tiene el rol de administrador
        boolean isAdmin = authorities.stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));

        // Determinar qué página de inicio mostrar según el rol del usuario
        if (isAdmin) {
            return "plantilla/template_admin";
        } else {
            return "plantilla/template_user";
        }
    }



}
