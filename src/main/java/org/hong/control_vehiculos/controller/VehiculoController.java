package org.hong.control_vehiculos.controller;

import jakarta.validation.Valid;
import org.hong.control_vehiculos.entity.Propietario;
import org.hong.control_vehiculos.entity.Vehiculo;
import org.hong.control_vehiculos.repository.VehiculoRepository;
import org.hong.control_vehiculos.service.PropietarioServiceImpl;
import org.hong.control_vehiculos.service.VehiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("vehiculos")
@CrossOrigin(origins ="*")
public class VehiculoController {

    @Autowired
    private VehiculoServiceImpl vehiculoService;
    @Autowired
    private PropietarioServiceImpl propietarioService;
    private final VehiculoRepository vehiculoRepository;


    // Constructor injection
    public VehiculoController(VehiculoServiceImpl vehiculoService, PropietarioServiceImpl propietarioService,
                              VehiculoRepository vehiculoRepository) {
        this.vehiculoService = vehiculoService;
        this.propietarioService = propietarioService;
        this.vehiculoRepository = vehiculoRepository;
    }

//    @GetMapping("/vehiculos/formulario")
//    public String mostrarFormularioVehiculo(Model model) {
//        model.addAttribute("vehiculo", new Vehiculo()); // Si necesitas un vehículo para el formulario
//        List<Propietario> propietarios = propietarioService.listarPropietarios(); // Obtener la lista de propietarios
//        model.addAttribute("propietarios", propietarios); // Agregar la lista al modelo
//        return "vehiculos/formulario";
//    }

    @GetMapping("/")
    public String listarVehiculos(Model model) {
        List<Vehiculo> listadoVehiculos = vehiculoService.listarVehiculos();
        model.addAttribute("titulo", "Listado de Vehículos");
        model.addAttribute("vehiculos", listadoVehiculos);
        return "vehiculos/listar";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        Vehiculo vehiculo = new Vehiculo();
        List<Propietario> propietarios = propietarioService.listarPropietarios(); // Obtener lista de propietarios desde el servicio
        model.addAttribute("titulo", "Formulario: Nuevo Vehículo");
        model.addAttribute("vehiculo", vehiculo);
        model.addAttribute("propietarios", propietarios);
        return "vehiculos/crear";
    }

    @PostMapping("/save")
    public String guardarVehiculo(@Valid @ModelAttribute Vehiculo vehiculo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nuevo Vehículo");
            model.addAttribute("vehiculo", vehiculo);
            System.out.println("Error en el formulario");
            return "vehiculos/crear";
        }

        // Obtener el ID del propietario seleccionado desde el formulario
        Long idPropietario = vehiculo.getPropietario().getId_propietario();
        // Obtener el propietario desde la base de datos utilizando el ID
        Propietario propietario = propietarioService.buscarPropietarioPorId(idPropietario);
        // Establecer el propietario en el vehículo
        vehiculo.setPropietario(propietario);

        // Guardar el vehículo con el propietario correctamente establecido
        vehiculoService.guardarVehiculo(vehiculo);
        System.out.println("Vehiculo " + vehiculo.getCod_vehiculo() + " : Datos guardados con éxito");
        return "redirect:/vehiculos/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Vehiculo vehiculo = vehiculoService.buscarVehiculoPorId(id);
        if (vehiculo != null) {
            List<Propietario> propietarios = propietarioService.listarPropietarios(); // Obtener la lista de propietarios
            model.addAttribute("vehiculo", vehiculo);
            model.addAttribute("propietarios", propietarios); // Añadir la lista al modelo
            model.addAttribute("titulo", "Formulario: Editar Vehículo");
            return "/vehiculos/crear";
        } else {
            return "redirect:/vehiculos/";
        }
    }


    @GetMapping("/propietario/{id}")
    @ResponseBody
    public Propietario obtenerPropietario(@PathVariable("id") Long id) {
        return propietarioService.buscarPropietarioPorId(id);
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        Vehiculo vehiculo = vehiculoService.buscarVehiculoPorId(id);
        if (vehiculo == null) {
            System.out.println("El vehículo no existe");
            return "redirect:/vehiculos/";
        }
        model.addAttribute("vehiculo", vehiculo);
        vehiculoService.eliminarVehiculo(id);
        System.out.println("Datos del vehículo " + vehiculo.getMatricula() + " eliminados con éxito");
        return "redirect:/vehiculos/";
    }

//    @GetMapping("/buscar")
//    @ResponseBody
//    public List<String> buscarMatriculas(@RequestParam String term) {
//        List<String> matriculas = vehiculoRepository.findByMatriculaContainingIgnoreCase(term)
//                .stream()
//                .map(Vehiculo::getMatricula)
//                .collect(Collectors.toList());
//
//        System.out.println("Matrículas encontradas: " + matriculas); // Debug en consola
//        return matriculas;
//    }


}
