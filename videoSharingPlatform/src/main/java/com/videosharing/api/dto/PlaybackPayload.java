package com.videosharing.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public final class PlaybackPayload {
	@NotNull(message = "User ID field is required.")
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}",
            message = "User ID must be valid UUID string.")
    private final String user;
    
	@NotNull(message = "Video ID field is required.")
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}",
            message = "Video ID must be valid UUID string.")
    private final String video;
	
	@NotNull(message = "Ad ID field is required.")
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}",
            message = "Ad ID must be valid UUID string.")
    private final String ad;
}