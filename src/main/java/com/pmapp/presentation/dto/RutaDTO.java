package com.pmapp.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RutaDTO {

    @NotBlank(message = "El código de la ruta es obligatorio")
    @Size(max = 50, message = "El código de la ruta no debe exceder los 50 caracteres")
    private String codigo;

    @NotBlank(message = "El nombre de la ruta es obligatorio")
    @Size(max = 50, message = "El nombre de la ruta no debe exceder los 50 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción de la ruta es obligatoria")
    @Size(max = 100, message = "La descripción no debe exceder los 100 caracteres")
    private String descripcion;

    @NotNull(message = "La hora inicial es obligatoria")
    private Timestamp initialHour;

    @NotNull(message = "La hora final es obligatoria")
    private Timestamp finalHour;
}
