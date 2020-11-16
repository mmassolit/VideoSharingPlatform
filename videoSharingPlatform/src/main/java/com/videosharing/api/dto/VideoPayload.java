package com.videosharing.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public final class VideoPayload {
    @NotNull(message = "Video name field is required.")
    @Pattern(regexp = "^([a-zA-Z0-9!?#.,()_]+( [a-zA-Z0-9!?#.,()_]+)*){5,150}$",
            message = "Video name should have length from 5 to 150 symbols.")
    private String name;
    
    @NotNull(message = "User ID field is required.")
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}",
            message = "User ID must be valid UUID string.")
    private String user;
}