package com.pmapp.service.interfaces;

import com.pmapp.presentation.dto.EstacionRutaDTO;
import com.pmapp.presentation.dto.result.DemandaEstacionRutaDto;

import java.util.List;
import java.util.Optional;

public interface IEstacionRutaService {

    // Método para obtener la demanda de estaciones y rutas
    List<DemandaEstacionRutaDto> getDemandaEstacionRuta();

    // Obtener todas las relaciones estación-ruta
    List<EstacionRutaDTO> getAllEstacionRutas();

    // Obtener una relación estación-ruta por su ID
    Optional<EstacionRutaDTO> getEstacionRutaById(Long id);
}
