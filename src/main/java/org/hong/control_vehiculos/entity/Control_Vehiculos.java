package org.hong.control_vehiculos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "control_vehiculos")
public class Control_Vehiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_control")
    private Long cod_control;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_vehiculo")
    private Vehiculo vehiculo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado")
    private Usuario usuario;

    @Column(name ="fecha_entrada")
    private LocalDateTime fecha_entrada;

    @Column(name = "fecha_salida")
    private LocalDateTime fecha_salida;

    @Column(name = "Observaciones")
    private String observaciones;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "empresa")
    private String empresa;

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy : HH:mm");

    public String getFechaEntradaFormateada() {
        return fecha_entrada != null ? fecha_entrada.format(FORMATO) : null;
    }

    public String getFechaSalidaFormateada() {
        return fecha_salida != null ? fecha_salida.format(FORMATO) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Control_Vehiculos that)) return false;
        return Objects.equals(getCod_control(), that.getCod_control()) &&
                Objects.equals(getVehiculo(), that.getVehiculo()) &&
                Objects.equals(getUsuario(), that.getUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCod_control(), getVehiculo(), getUsuario());
    }

    // Métodos adicionales para cod_vehiculo
    public Long getCod_vehiculo() {
        return vehiculo != null ? vehiculo.getCod_vehiculo() : null;
    }

    public void setCod_vehiculo(Long cod_vehiculo) {
        if (this.vehiculo == null) {
            this.vehiculo = new Vehiculo();
        }
        this.vehiculo.setCod_vehiculo(cod_vehiculo);
    }
}
