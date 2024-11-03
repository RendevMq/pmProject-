package com.pmapp.presentation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstacionRutaDTO {

    @NotNull(message = "El ID es obligatorio")
    private Long id;

    @NotNull(message = "La estación es obligatoria")
    private EstacionDTO estacion;

    @NotNull(message = "La ruta es obligatoria")
    private RutaDTO ruta;

    @NotNull(message = "El número de pasajeros es obligatorio")
    @Min(value = 0, message = "El número de pasajeros no puede ser negativo")
    private Integer numeroPasajeros;
}
