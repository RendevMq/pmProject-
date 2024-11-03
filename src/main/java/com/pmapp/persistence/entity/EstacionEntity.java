package com.pmapp.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estaciones")
public class EstacionEntity {

    @Id
    @Column(length = 4, nullable = false)
    private String codigo;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 70, nullable = false)
    private String direccion;

    @Column(nullable = false)
    private int estado;

    @Column(name = "date_created")
    @CreationTimestamp
    private Timestamp dateCreated;

    @Column(name = "date_updated")
    @UpdateTimestamp
    private Timestamp dateUpdated;
}
