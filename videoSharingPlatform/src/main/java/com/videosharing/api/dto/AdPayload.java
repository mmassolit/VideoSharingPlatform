package com.videosharing.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public final class AdPayload {
    @NotNull(message = "CPM field is required.")
    @Positive(message = "CPM must be positive.")
    private final double cpm;
    
    @NotNull(message = "Budget field is required.")
    @Positive(message = "Budget must be positive.")
    private final double budget;
}