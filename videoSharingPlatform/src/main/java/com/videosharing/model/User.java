package com.videosharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

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
    private String name;
    private String surname;
    private String email;
    private Double balance;

    public User(String name, String surname, String email) {
        this(UUID.randomUUID().toString(), ZonedDateTime.now(ZoneId.of("UTC+3")), name, surname, email, 0.0);
    }
}