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
@Table(name = "ads")

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Ad {
    @Id
    private String id;
    private ZonedDateTime dateCreated;
    private double cpm;
    private double budget;
    
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    public Ad(double cpm, double budget, User user) {
        this(UUID.randomUUID().toString(), ZonedDateTime.now(ZoneId.of("UTC+3")), cpm, budget, user);
    }
}