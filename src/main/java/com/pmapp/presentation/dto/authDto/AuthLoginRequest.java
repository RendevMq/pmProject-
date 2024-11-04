package com.pmapp.presentation.dto.authDto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String email,
                               @NotBlank String password) {
}
