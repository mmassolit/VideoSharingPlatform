package com.videosharing.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "playbacks")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Playback {
	
    @Id
    private String id;
    private ZonedDateTime dateCreated;
    
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;
    
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "idVideo", nullable = false)
    private Video video;
    
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "idAd", nullable = false)
    private Ad ad;

    public Playback(User user, Video video, Ad ad){
        this(UUID.randomUUID().toString(), ZonedDateTime.now(ZoneId.of("UTC+3")), user, video, ad);
    }
}