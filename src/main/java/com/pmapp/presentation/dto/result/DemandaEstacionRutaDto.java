package com.pmapp.presentation.dto.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public interface DemandaEstacionRutaDto {
    String getEstacion();
    String getRuta();
    Integer getPasajerosEsperando();
    LocalDateTime getHora(); // Asegúrate de que el tipo coincida con lo que esperas
    Long getBuses(); // Cambia a Long si `count` devuelve un Long
}
