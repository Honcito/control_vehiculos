package org.hong.control_vehiculos.controller;


import org.hong.control_vehiculos.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.hong.control_vehiculos.entity.Rol.ROLE_USER;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioController usuarioController;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {
        try {
            usuario.setRol(ROLE_USER); // Establece el rol por defecto
            ResponseEntity<Object> response = usuarioController.saveUser(usuario, result);
            if (response.getStatusCode().is2xxSuccessful()) {
                return "redirect:/usuarios/listar"; // Redirige a la lista de usuarios
            } else {
                model.addAttribute("error", "Error al registrar el usuario: " + response.getBody());
                return "auth/register"; // Vuelve a la vista de registro con el mensaje de error
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el usuario: " + e.getMessage());
            return "auth/register"; // Vuelve a la vista de registro con el mensaje de error
        }
    }
}
