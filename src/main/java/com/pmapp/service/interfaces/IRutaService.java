package com.pmapp.service.interfaces;

import com.pmapp.presentation.dto.RutaDTO;

import java.util.List;
import java.util.Optional;

public interface IRutaService {

    // Obtener todas las rutas
    List<RutaDTO> getAllRutas();

    // Obtener una ruta por su código
    Optional<RutaDTO> getRutaByCodigo(String codigo);
}
