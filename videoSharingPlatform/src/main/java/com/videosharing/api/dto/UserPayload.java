package com.videosharing.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    
    @NotNull(message = "Password field is required.")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,}).{8,}$",
            message = "Passowrd should contain at least 1 upper case letter, 1 lowwer case letter "
            		+ "and 1 digit and have length at least 8 characters.")
    
    private String password;
    
    @NotNull(message = "Email field is required.")
    @Email(message = "Enter a valid email.")
    private String email;
}