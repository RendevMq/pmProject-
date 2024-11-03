package com.pmapp.presentation.dto;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CronogramaBusDTO {

    @NotNull(message = "El ID es obligatorio")
    private Long id;

    @NotNull(message = "El bus es obligatorio")
    private BusDTO bus;

    @NotNull(message = "La estación-ruta es obligatoria")
    private EstacionRutaDTO estacionRuta;

    @NotNull(message = "La hora de salida es obligatoria")
    private Timestamp horaSalida;

    @NotNull(message = "La hora de llegada es obligatoria")
    private Timestamp horaLlegada;

}

