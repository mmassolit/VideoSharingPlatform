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
@Table(name = "videos")

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Video {
    @Id
    private String id;
    private ZonedDateTime dateCreated;
    private String name;
    private int views;
    
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    public Video(String name, User userCreator) {
        this(UUID.randomUUID().toString(), ZonedDateTime.now(ZoneId.of("UTC+3")), name, 0, userCreator);
    }
}