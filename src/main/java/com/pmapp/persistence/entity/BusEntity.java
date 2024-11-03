package com.pmapp.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buses")
public class BusEntity {

    @Id
    @Column(name = "codigo_bus", length = 50, nullable = false)
    private String codigo;

    @Column(length = 50, nullable = false)
    private String capacidad;

    @Column(nullable = false)
    private int estado;
}
