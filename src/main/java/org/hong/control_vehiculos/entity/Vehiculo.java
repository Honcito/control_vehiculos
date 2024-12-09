package org.hong.control_vehiculos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_vehiculo")
    private Long cod_vehiculo;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "num_aparcamiento")
    private int num_aparcamiento;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_propietario")
    private  Propietario propietario;


    @OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Control_Vehiculos> controlVehículos;
}
