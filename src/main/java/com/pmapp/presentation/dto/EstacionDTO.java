package com.pmapp.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstacionDTO {

    @NotBlank(message = "El código de la estación es obligatorio")
    @Size(max = 4, message = "El código de la estación no debe exceder los 4 caracteres")
    private String codigo;

    @NotBlank(message = "El nombre de la estación es obligatorio")
    @Size(max = 50, message = "El nombre de la estación no debe exceder los 50 caracteres")
    private String nombre;

    @NotBlank(message = "La dirección de la estación es obligatoria")
    @Size(max = 70, message = "La dirección no debe exceder los 70 caracteres")
    private String direccion;

    @NotNull(message = "El estado de la estación es obligatorio")
    private Integer estado;
}
