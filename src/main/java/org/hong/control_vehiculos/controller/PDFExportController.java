package org.hong.control_vehiculos.controller;

import org.hong.control_vehiculos.entity.Control_Vehiculos;
import org.hong.control_vehiculos.repository.ControlVehiculoRepository;
import org.hong.control_vehiculos.service.DatabasePDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class PDFExportController {

    @Autowired
    ControlVehiculoRepository controlVehiculoRepository;

    @GetMapping(value = "/openpdf/control_vehiculos", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> control_vehiculos_report()  throws IOException {
        List<Control_Vehiculos> controlVehiculos = (List<Control_Vehiculos>) controlVehiculoRepository.findAll();

        ByteArrayInputStream bis = DatabasePDFService.employeePDFReport(controlVehiculos);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=control_vehiculos.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
