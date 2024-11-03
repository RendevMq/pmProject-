package com.pmapp.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "demanda_estaciones")
public class DemandaEstacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_estacion_por_ruta", nullable = false)
    private EstacionRutaEntity estacionRuta;

    @Column(name = "numero_pasajeros", nullable = false)
    private int numeroPasajeros;

    @Column(nullable = false)
    private Timestamp hora;

    @Column(length = 40)
    private String dia;

    @Column(length = 50)
    private String clima;

    @Column(name = "evento_especial", length = 40)
    private String eventoEspecial;
}
