package com.pmapp.persistence.repository;

import com.pmapp.persistence.entity.BusEntity;
import com.pmapp.persistence.entity.CronogramaBusEntity;
import com.pmapp.persistence.entity.EstacionRutaEntity;
import com.pmapp.presentation.dto.result.CronogramaBusQueryDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CronogramaBusRepository extends CrudRepository<CronogramaBusEntity, Long> {

    // Encuentra los cronogramas de un bus específico
    List<CronogramaBusEntity> findByBus(BusEntity bus);

    // Encuentra todos los cronogramas de una estación de ruta
    List<CronogramaBusEntity> findByEstacionRuta(EstacionRutaEntity estacionRuta);

    // Encuentra cronogramas por hora de salida dentro de un rango
    List<CronogramaBusEntity> findByHoraSalidaBetween(Timestamp start, Timestamp end);

    @Query(value = """
        SELECT buses.codigo_bus AS codigoBus, 
               estaciones.nombre AS estacion,
               rutas.nombre AS ruta, 
               cronograma.hora_salida AS horaSalida
        FROM cronograma_buses cronograma
        JOIN estaciones_rutas estacio_rutas ON cronograma.id_estacion_bus = estacio_rutas.id
        JOIN estaciones estaciones ON estaciones.codigo = estacio_rutas.estacion
        JOIN rutas ON rutas.codigo_rut = estacio_rutas.ruta
        JOIN buses ON cronograma.codigo_bus = buses.codigo_bus
        ORDER BY 4,1,2
        """, nativeQuery = true)
    List<CronogramaBusQueryDto> findCronogramaBusDetails();
}
