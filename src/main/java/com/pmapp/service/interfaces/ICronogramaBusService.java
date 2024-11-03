package com.pmapp.service.interfaces;

import com.pmapp.presentation.dto.CronogramaBusDTO;
import com.pmapp.presentation.dto.result.CronogramaBusQueryDto;

import java.util.List;
import java.util.Optional;

public interface ICronogramaBusService {

    // Obtener todos los cronogramas de buses
    List<CronogramaBusDTO> getAllCronogramas();

    // Obtener un cronograma de bus por su ID
    Optional<CronogramaBusDTO> getCronogramaById(Long id);

    // Nuevo métodoO para obtener el detalle del cronograma
    List<CronogramaBusQueryDto> getCronogramaBusDetails();
}
