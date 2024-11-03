package com.pmapp.persistence.repository;

import com.pmapp.persistence.entity.RutaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RutaRepository extends CrudRepository<RutaEntity, String> {

    // Encuentra rutas por nombre
    List<RutaEntity> findByNombreContaining(String nombre);

    // Encuentra rutas por hora de inicio en un rango de tiempo
    //List<RutaEntity> findByInitialHourBetween(Timestamp start, Timestamp end);

    // Encuentra rutas activas entre las horas inicial y final
    //List<RutaEntity> findByInitialHourBeforeAndFinalHourAfter(Timestamp currentHour);
}

