package org.hong.control_vehiculos.service;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.hong.control_vehiculos.entity.Control_Vehiculos;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

public class DatabasePDFService {

    public static ByteArrayInputStream employeePDFReport(List<Control_Vehiculos> controlVehiculos) {
        Document document = new Document(PageSize.A4.rotate()); // Orientación horizontal
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            // Add Content to PDF file ->
            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Base de Datos de Control de Vehículos", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(5);
            // Add PDF Table Header ->
            Stream.of("ID", "Matrícula", "Fecha/Hora Salida", "Fecha/Hora Entrada", "Empresa").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(Color.CYAN);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });

            for (Control_Vehiculos control : controlVehiculos) {
                PdfPCell cod_Control = new PdfPCell(new Phrase(control.getCod_control().toString()));
                cod_Control.setPaddingLeft(4);
                cod_Control.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cod_Control.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cod_Control);

                PdfPCell matricula = new PdfPCell(new Phrase(control.getMatricula()));
                matricula.setPaddingLeft(4);
                matricula.setVerticalAlignment(Element.ALIGN_MIDDLE);
                matricula.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(matricula);

                PdfPCell fecha_salida = new PdfPCell(new Phrase(String.valueOf(control.getFechaSalidaFormateada())));
                fecha_salida.setVerticalAlignment(Element.ALIGN_MIDDLE);
                fecha_salida.setHorizontalAlignment(Element.ALIGN_CENTER);
                fecha_salida.setPaddingRight(4);
                table.addCell(fecha_salida);

                PdfPCell fecha_entrada = new PdfPCell(new Phrase(String.valueOf(control.getFechaEntradaFormateada())));
                fecha_entrada.setVerticalAlignment(Element.ALIGN_MIDDLE);
                fecha_entrada.setHorizontalAlignment(Element.ALIGN_CENTER);
                fecha_entrada.setPaddingRight(4);
                table.addCell(fecha_entrada);

                PdfPCell empresa = new PdfPCell(new Phrase(String.valueOf(control.getEmpresa())));
                empresa.setVerticalAlignment(Element.ALIGN_MIDDLE);
                empresa.setHorizontalAlignment(Element.ALIGN_CENTER);
                empresa.setPaddingRight(4);
                table.addCell(empresa);
            }
            document.add(table);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}
