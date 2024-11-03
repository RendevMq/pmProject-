package com.pmapp.persistence.repository;

import com.pmapp.persistence.entity.DemandaEstacionEntity;
import com.pmapp.persistence.entity.EstacionRutaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;
import java.util.List;

@Repository
public interface DemandaEstacionRepository extends CrudRepository<DemandaEstacionEntity, Long> {

    // Encuentra la demanda en una estación por ruta en un día específico
    List<DemandaEstacionEntity> findByEstacionRutaAndDia(EstacionRutaEntity estacionRuta, String dia);

    // Encuentra la demanda por estación y clima
    List<DemandaEstacionEntity> findByEstacionRutaAndClima(EstacionRutaEntity estacionRuta, String clima);

    // Encuentra la demanda por hora y evento especial
    List<DemandaEstacionEntity> findByHoraAndEventoEspecial(Timestamp hora, String eventoEspecial);
}

