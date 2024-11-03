package com.pmapp.service.interfaces;
import com.pmapp.presentation.dto.EstacionDTO;

import java.util.List;
import java.util.Optional;

public interface IEstacionService {

    // Obtener todas las estaciones
    List<EstacionDTO> getAllEstaciones();

    // Obtener una estación por su código
    Optional<EstacionDTO> getEstacionByCodigo(String codigo);
}

