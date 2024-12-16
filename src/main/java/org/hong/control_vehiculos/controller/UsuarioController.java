package org.hong.control_vehiculos.controller;

import jakarta.validation.Valid;
import org.hong.control_vehiculos.entity.Usuario;
import org.hong.control_vehiculos.repository.UsuarioRepository;
import org.hong.control_vehiculos.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String listarUsuarios(Model model) {
        List<Usuario> listadoUsuarios = usuarioService.listarUsuarios();
        model.addAttribute("titulo", "Listado de Usuarios");
        model.addAttribute("usuarios", listadoUsuarios);
        return "usuarios/listar"; // Nombre de la vista listado de usuarios
    }

    @GetMapping("/create")
    public String mostrarFormularioCrear(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("titulo", "Formulario: Nuevo Usuario");
        model.addAttribute("usuario", usuario);
        return "usuarios/crear"; // Nombre de la vista formulario de creación de usuario
    }

//    @PostMapping("/save")
//    public ResponseEntity<Object> saveUser(@Valid @RequestBody Usuario usuario, BindingResult result) {
//        if (result.hasErrors()) {
//            return ResponseEntity.badRequest().body("Error en los datos del usuario");
//        }
//
//        Usuario existingUser = usuarioService.buscarUsuarioPorId(usuario.getId_usuario());
//
//        // Si el usuario no existe o la contraseña es diferente, codifica la contraseña
//        if (existingUser == null || !passwordEncoder.matches(usuario.getPassword(), existingUser.getPassword())) {
//            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
//        } else {
//            // Mantener la contraseña existente si no ha cambiado
//            usuario.setPassword(existingUser.getPassword());
//        }
//
//        Usuario savedUser = usuarioRepository.save(usuario);
//        if (savedUser.getId_usuario() != null) {
//            return ResponseEntity.ok("Usuario guardado con éxito");
//        }
//        return ResponseEntity.status(500).body("Error: No se ha podido guardar el usuario");
//    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            // Manejar errores de validación si es necesario
            return ResponseEntity.badRequest().body("Error en los datos del usuario");
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario savedUser = usuarioRepository.save(usuario); // Cambiar el nombre de la variable
        if (savedUser.getId_usuario() > 0) {
            return ResponseEntity.ok("Usuario guardado con éxito");
        }
        return ResponseEntity.status(500).body("Error: No se ha podido guardar el usuario");
    }


    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idUsuario, Model model) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("Error: El id del usuario no existe.");
            return "redirect:/usuarios/listar/"; // Redirigir a la página principal de usuarios
        }
        model.addAttribute("titulo", "Formulario: Editar Usuario");
        model.addAttribute("usuario", usuario);
        return "usuarios/crear"; // Nombre de la vista formulario de edición de usuario
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idUsuario) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("Error: El id del usuario no existe.");
            return "redirect:/usuarios/";
        } else {
            usuarioService.eliminarUsuario(idUsuario);
            System.out.println("Usuario eliminado con éxito.");
        }
        return "redirect:/usuarios/"; // Redirigir a la página principal de usuarios
    }
}
