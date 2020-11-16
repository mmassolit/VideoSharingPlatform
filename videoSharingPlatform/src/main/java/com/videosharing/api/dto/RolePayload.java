package com.videosharing.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public final class RolePayload {
    @NotNull(message = "Role name field is required.")
    @Pattern(regexp = "^[a-zA-Z]{2,20}",
            message = "Role name should consist only of letters and have length from 2 to 20 characters.")
    private String name;
    
    @NotNull(message = "AllowedAds field is required.")
    private boolean allowedAds;
    
    @NotNull(message = "AllowedVideos field is required.")
    private boolean allowedVideos;
}