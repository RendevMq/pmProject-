package com.pmapp.persistence.repository;

import com.pmapp.persistence.entity.BusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends CrudRepository<BusEntity, String> {

    // Encuentra un bus por su estado
    List<BusEntity> findByEstado(int estado);

    // Encuentra todos los buses por capacidad
    List<BusEntity> findByCapacidad(String capacidad);

    // Verifica si existe un bus por su código
    boolean existsByCodigo(String codigo);
}
