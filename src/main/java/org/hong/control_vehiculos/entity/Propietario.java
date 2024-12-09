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
@Table(name = "propietarios")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propietario")
    private Long id_propietario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "plazas")
    private String plazas;

    @OneToMany(mappedBy = "propietario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos;

}
