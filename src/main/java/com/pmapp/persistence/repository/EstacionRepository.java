package com.pmapp.persistence.repository;

import com.pmapp.persistence.entity.EstacionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstacionRepository extends CrudRepository<EstacionEntity, String> {

    // Encuentra estaciones por nombre
    List<EstacionEntity> findByNombreContaining(String nombre);

    // Encuentra estaciones por estado
    List<EstacionEntity> findByEstado(int estado);

    // Encuentra una estación por dirección
    Optional<EstacionEntity> findByDireccion(String direccion);
}

