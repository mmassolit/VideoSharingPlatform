package com.videosharing.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Email;

@Data
public final class UserPayload {
	@NotNull(message = "Role ID field is required.")
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}",
            message = "Role ID must be valid UUID string.")
    private String role;
	
    @NotNull(message = "Name field is required.")
    @Pattern(regexp = "^[a-zA-Z]{2,20}",
            message = "Name should consist only of letters and have length from 2 to 20 characters.")
    private String name;
    
    @NotNull(message = "Surname field is required.")
    @Pattern(regexp = "^[a-zA-Z]{2,20}",
            message = "Surname should only consist of letters and have length from 2 to 20 characters.")
    private String surname;
    
    @NotNull(message = "Email field is required.")
    @Email(message = "Enter a valid email.")
    private String email;
    
    @NotNull(message = "Balance field is required.")
    @PositiveOrZero(message = "Balance can't be negative.")
    private double balance;
}