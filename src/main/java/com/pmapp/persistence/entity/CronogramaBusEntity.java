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
@Table(name = "cronograma_buses", uniqueConstraints = @UniqueConstraint(columnNames = {"codigo_bus", "id_estacion_bus", "hora_salida"}))
public class CronogramaBusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "codigo_bus", nullable = false)
    private BusEntity bus;

    @ManyToOne
    @JoinColumn(name = "id_estacion_bus")
    private EstacionRutaEntity estacionRuta;

    @Column(name = "hora_salida")
    private Timestamp horaSalida;

    @Column(name = "hora_llegada")
    private Timestamp horaLlegada;
}
