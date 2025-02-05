package org.hong.control_vehiculos.controller;

import org.hong.control_vehiculos.entity.Control_Vehiculos;
import org.hong.control_vehiculos.entity.Usuario;
import org.hong.control_vehiculos.entity.Vehiculo;
import org.hong.control_vehiculos.repository.ControlVehiculoRepository;
import org.hong.control_vehiculos.service.DatabasePDFService;
import org.hong.control_vehiculos.service.IControlVehiculoService;
import org.hong.control_vehiculos.service.IUsuarioService;
import org.hong.control_vehiculos.service.IVehiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/control_vehiculos")
public class ControlVehiculoController {

    @Autowired
    private IControlVehiculoService controlVehiculoService;

    @Autowired
    private IVehiculoService vehiculoService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ControlVehiculoRepository controlVehiculoRepository;

    private static final Logger logger = LoggerFactory.getLogger(ControlVehiculoController.class);


    @GetMapping("/")
    public String listarControlVehiculos(Model model) {
        LocalDateTime fechaLimite = LocalDateTime.now().minusDays(2);
        List<Control_Vehiculos> listadoControles = controlVehiculoService.listarControlVehiculos(fechaLimite);
        model.addAttribute("titulo", "Listado de Control de Vehículos");
        model.addAttribute("listadoControles", listadoControles);
        return "control_vehiculos/listar"; // Nombre del template Thymeleaf
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Control_Vehiculos>> listarControl() {
        LocalDateTime fechaLimite = LocalDateTime.now().minusDays(2);
        List<Control_Vehiculos> listadoControles = controlVehiculoService.listarControlVehiculos(fechaLimite);
//        model.addAttribute("titulo", "Listado de Control de Vehículos");
//        model.addAttribute("listadoControles", listadoControles);
//        return "control_vehiculos/listar"; // Nombre del template Thymeleaf
        return ResponseEntity.ok(listadoControles);
    }

    @PostMapping("/guardar")
    @ResponseBody
    public Map<String, Object> guardarControlVehiculos(@RequestBody Control_Vehiculos controlVehiculos, Authentication authentication) {
        logger.info("Datos recibidos para guardar: {}", controlVehiculos);

        // Obtener el usuario logueado
        String username = authentication.getName();
        Usuario usuarioLogueado = usuarioService.buscarUsuarioPorNombre(username);

        // Asignar el usuario logueado al control de vehículos
        controlVehiculos.setUsuario(usuarioLogueado);

        // Obtener el vehículo por matrícula
        Vehiculo vehiculo = vehiculoService.buscarVehiculoPorMatricula(controlVehiculos.getMatricula());
        if (vehiculo != null) {
            controlVehiculos.setVehiculo(vehiculo);
            controlVehiculos.setCod_vehiculo(vehiculo.getCod_vehiculo());
        }

        // Guardar el control de vehículos
        controlVehiculoService.guardar(controlVehiculos);

        // Devolver el ID del control de vehículos guardado
        Map<String, Object> response = new HashMap<>();
        response.put("cod_control", controlVehiculos.getCod_control());
        return response;
    }

    @PutMapping("/actualizar/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, String>> actualizarControlVehiculos(@PathVariable Long id, @RequestBody Control_Vehiculos controlVehiculos) {
        Control_Vehiculos controlExistente = controlVehiculoService.buscarControlPorId(id);

        if (controlExistente != null) {
            logger.info("Actualizando control de vehículo con ID: {}", id);
            logger.info("Datos recibidos para actualizar: {}", controlVehiculos);

            // Actualizar los campos del control existente
            controlExistente.setMatricula(controlVehiculos.getMatricula());
            controlExistente.setEmpresa(controlVehiculos.getEmpresa());
            controlExistente.setObservaciones(controlVehiculos.getObservaciones());

            // Actualizar fecha de salida si se proporciona
            if (controlVehiculos.getFecha_salida() != null) {
                controlExistente.setFecha_salida(controlVehiculos.getFecha_salida());
            }

            // Actualizar fecha de entrada si se proporciona
            if (controlVehiculos.getFecha_entrada() != null) {
                controlExistente.setFecha_entrada(controlVehiculos.getFecha_entrada());
            }

            // Guardar el control de vehículos actualizado
            controlVehiculoService.guardar(controlExistente);

            // Preparar la respuesta
            Map<String, String> response = new HashMap<>();
            response.put("message", "Actualización exitosa");
            return ResponseEntity.ok(response);
        } else {
            // Si no se encuentra el control de vehículos
            Map<String, String> response = new HashMap<>();
            response.put("message", "Control de vehículos no encontrado");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/obtenerCodVehiculo")
    @ResponseBody
    public Map<String, Object> obtenerCodVehiculo(@RequestParam("matricula") String matricula) {
        Vehiculo vehiculo = vehiculoService.buscarVehiculoPorMatricula(matricula);
        Map<String, Object> response = new HashMap<>();
        if (vehiculo != null) {
            response.put("cod_vehiculo", vehiculo.getCod_vehiculo());
            response.put("nombre_empresa", vehiculo.getPropietario() != null ? vehiculo.getPropietario().getEmpresa() : "");
        } else {
            response.put("cod_vehiculo", null);
            response.put("nombre_empresa", "");
        }
        return response;
    }

    @GetMapping(value = "/openpdf/control_vehiculos", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> control_vehiculos_report() throws IOException {
        List<Control_Vehiculos> controlVehiculos = controlVehiculoRepository.findAll();

        ByteArrayInputStream bis = DatabasePDFService.employeePDFReport(controlVehiculos);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=control_vehiculos.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, String>> eliminarControlVehiculos(@PathVariable Long id) {
        Control_Vehiculos controlExistente = controlVehiculoService.buscarControlPorId(id);
        if (controlExistente != null) {
            controlVehiculoService.eliminar(controlExistente);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Eliminación exitosa");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Control de vehículos no encontrado");
            return ResponseEntity.notFound().build();
        }
    }
}
