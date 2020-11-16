package com.videosharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "users")

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class User {
    @Id
    private String id;
    private ZonedDateTime dateCreated;
    
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "idRole", nullable = false)
    private Role role;
    
    private String name;
    private String password;
    
    private String email;
    private double balance;
    
    public User(Role role, String name, String password, String email) {
        this(UUID.randomUUID().toString(), ZonedDateTime.now(ZoneId.of("UTC+3")), role, name, password, email, 0.0);
    }
}