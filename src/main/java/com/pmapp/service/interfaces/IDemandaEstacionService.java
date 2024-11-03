package com.pmapp.service.interfaces;

import com.pmapp.presentation.dto.DemandaEstacionDTO;

import java.util.List;
import java.util.Optional;

public interface IDemandaEstacionService {

    // Obtener toda la demanda en estaciones
    List<DemandaEstacionDTO> getAllDemandas();

    // Obtener la demanda en una estación específica por su ID
    Optional<DemandaEstacionDTO> getDemandaById(Long id);
}
