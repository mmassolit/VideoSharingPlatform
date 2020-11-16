package com.videosharing.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
public final class AdPayload {
    @NotNull(message = "CPM field is required.")
    @Positive(message = "CPM must be positive.")
    private double cpm;
    
    @NotNull(message = "Budget field is required.")
    @Positive(message = "Budget must be positive.")
    private double budget;
    
    @NotNull(message = "User ID field is required.")
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}",
            message = "User ID must be valid UUID string.")
    private String user;
}