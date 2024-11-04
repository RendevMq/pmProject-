package com.pmapp.presentation.dto.authDto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email", "message", "accessToken"})
public record AuthResponse(String email, String message, String accessToken, boolean status) {
}
