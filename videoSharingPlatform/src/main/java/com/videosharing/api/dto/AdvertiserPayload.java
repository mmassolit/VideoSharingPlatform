package com.videosharing.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Data
public final class AdvertiserPayload {
    @NotNull(message = "Name field is required.")
    @Pattern(regexp = "^[a-zA-Z]{2,20}",
            message = "Name should consist only of letters and have length from 2 to 20 characters.")
    private final String name;
    
    @NotNull(message = "Surname field is required.")
    @Pattern(regexp = "^[a-zA-Z]{2,20}",
            message = "Surname should only consist of letters and have length from 2 to 20 characters.")
    private final String surname;
    
    @NotNull(message = "Email field is required.")
    @Pattern(regexp = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b",
            message = "Enter a valid email.")
    private final String email;
    
    @NotNull(message = "Balance field is required.")
    @PositiveOrZero(message = "Balance can't be negative.")
    private final double balance;
}