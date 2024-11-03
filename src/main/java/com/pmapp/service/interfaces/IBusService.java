package com.pmapp.service.interfaces;

import com.pmapp.presentation.dto.BusDTO;

import java.util.List;
import java.util.Optional;

public interface IBusService {

    // Obtener todos los buses
    List<BusDTO> getAllBuses();

    // Obtener un bus por su código
    Optional<BusDTO> getBusByCodigo(String codigo);
}
