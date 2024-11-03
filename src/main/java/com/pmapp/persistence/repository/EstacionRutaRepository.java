package com.pmapp.persistence.repository;

import com.pmapp.persistence.entity.EstacionEntity;
import com.pmapp.persistence.entity.EstacionRutaEntity;
import com.pmapp.persistence.entity.RutaEntity;
import com.pmapp.presentation.dto.result.DemandaEstacionRutaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstacionRutaRepository extends JpaRepository<EstacionRutaEntity, Long> {

    @Query(value = """
    SELECT e.nombre AS estacion, 
           r.codigo_rut AS ruta, 
           d.numero_pasajeros AS pasajerosEsperando, 
           d.hora AS hora, 
           COUNT(cb.id) AS buses
    FROM estaciones_rutas er
    JOIN estaciones e ON e.codigo = er.estacion
    JOIN rutas r ON r.codigo_rut = er.ruta
    JOIN demanda_estaciones d ON d.id_estacion_por_ruta = er.id
    JOIN cronograma_buses cb ON cb.id_estacion_bus = er.id AND d.hora = cb.hora_salida
    GROUP BY e.nombre, r.codigo_rut, d.numero_pasajeros, d.hora
    ORDER BY d.hora, e.nombre, r.codigo_rut
""", nativeQuery = true)
    List<DemandaEstacionRutaDto> findDemandaEstacionRuta();

    // Encuentra todas las rutas por una estación específica
    List<EstacionRutaEntity> findByEstacion(EstacionEntity estacion);

    // Encuentra todas las estaciones por una ruta específica
    List<EstacionRutaEntity> findByRuta(RutaEntity ruta);

    // Encuentra una estación específica dentro de una ruta
    Optional<EstacionRutaEntity> findByEstacionAndRuta(EstacionEntity estacion, RutaEntity ruta);
}

