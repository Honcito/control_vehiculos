package org.hong.control_vehiculos.controller;

import jakarta.validation.Valid;
import org.hong.control_vehiculos.entity.Propietario;
import org.hong.control_vehiculos.service.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("propietarios")
public class PropietarioController {

    @Autowired
    private IPropietarioService propietarioService;

    @GetMapping("/")
    public String listarPropietarios(Model model) {
        List<Propietario> listadoPropietarios = propietarioService.listarPropietarios();
        model.addAttribute("titulo", "Listado de Propietarios");
        model.addAttribute("propietarios", listadoPropietarios);
        return "propietarios/listar";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        Propietario propietario = new Propietario();
        model.addAttribute("titulo", "Formulario: Nuevo Propietario");
        model.addAttribute("propietario", propietario);
        return "propietarios/crear";
    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Propietario propietario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nuevo Propietario");
            model.addAttribute("propietario", propietario);
            System.out.println("Error en el formulario");
            return "propietarios/crear";
        }
        propietarioService.guardarPropietario(propietario);
        System.out.println("Propietario " + propietario.getNombre() + ": Datos guardados con éxito");
        return "redirect:/propietarios/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Propietario propietario = propietarioService.buscarPropietarioPorId(id);
        if (propietario == null){
            System.out.println("El propietario no existe");
            return "redirect:/propietarios/listar";
        }
        model.addAttribute("titulo", "Formulario: Editar Propietario");
        model.addAttribute("propietario", propietario);
        System.out.println("Propietario " + propietario.getNombre() + ": Datos modificados");
        return "propietarios/crear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model){
        Propietario propietario = propietarioService.buscarPropietarioPorId(id);
        if (propietario == null) {
            System.out.println("El propietario no existe");
            return "redirect:/propietarios/";
        }
        model.addAttribute("propietario", propietario);
        propietarioService.eliminarPropietario(id);
        System.out.println("Datos del propietario " + propietario.getNombre() + " eliminados con éxito");
        return "redirect:/propietarios/";
    }


}
