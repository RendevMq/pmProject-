package com.pmapp.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rutas")
public class RutaEntity {

    @Id
    @Column(name = "codigo_rut", length = 50, nullable = false)
    private String codigo;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(name = "rut_desc", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "initial_hour", nullable = false)
    private Timestamp initialHour;

    @Column(name = "final_hour", nullable = false)
    private Timestamp finalHour;
}
