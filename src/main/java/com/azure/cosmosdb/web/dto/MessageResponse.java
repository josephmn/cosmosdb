package com.azure.cosmosdb.web.dto;

public record MessageResponse(
    String id,
    String pk,
    String message,
    Boolean status
) {
}
