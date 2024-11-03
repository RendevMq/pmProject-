package com.pmapp.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estaciones_rutas")
public class EstacionRutaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estacion", nullable = false)
    private EstacionEntity estacion;

    @ManyToOne
    @JoinColumn(name = "ruta", nullable = false)
    private RutaEntity ruta;

    @Column(name = "numero_pasajeros", nullable = false, columnDefinition = "int4 default 0")
    private int numeroPasajeros;
}
