package com.azure.cosmosdb.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MessageRequest(
    @NotBlank String id,
    @NotNull String message,
    @NotNull Boolean status
) {
}
