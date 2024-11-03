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
public class BusDTO {

    @NotBlank(message = "El código del bus es obligatorio")
    @Size(max = 50, message = "El código del bus no debe exceder los 50 caracteres")
    private String codigo;

    @NotBlank(message = "La capacidad del bus es obligatoria")
    @Size(max = 50, message = "La capacidad no debe exceder los 50 caracteres")
    private String capacidad;

    @NotNull(message = "El estado del bus es obligatorio")
    private Integer estado;
}
