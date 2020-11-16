package com.videosharing.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
public final class PaymentPayload {
	@NotNull(message = "User ID field is required.")
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}",
            message = "User ID must be valid UUID string.")
    private final String userFrom;
    
	@NotNull(message = "User ID field is required.")
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}",
            message = "User ID must be valid UUID string.")
    private final String userTo;
	
	@NotNull(message = "Amount field is required.")
    @Positive(message = "Amount must be positive.")
    private final double amount;
}