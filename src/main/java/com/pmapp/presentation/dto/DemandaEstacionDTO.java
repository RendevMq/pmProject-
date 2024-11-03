package com.pmapp.presentation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemandaEstacionDTO {

    @NotNull(message = "El ID es obligatorio")
    private Long id;

    @NotNull(message = "La estación por ruta es obligatoria")
    private EstacionRutaDTO estacionRuta;

    @NotNull(message = "El número de pasajeros es obligatorio")
    @Min(value = 0, message = "El número de pasajeros no puede ser negativo")
    private Integer numeroPasajeros;

    @NotNull(message = "La hora es obligatoria")
    private Timestamp hora;

    @Size(max = 40, message = "El día no debe exceder los 40 caracteres")
    private String dia;

    @Size(max = 50, message = "El clima no debe exceder los 50 caracteres")
    private String clima;

    @Size(max = 40, message = "El evento especial no debe exceder los 40 caracteres")
    private String eventoEspecial;
}
