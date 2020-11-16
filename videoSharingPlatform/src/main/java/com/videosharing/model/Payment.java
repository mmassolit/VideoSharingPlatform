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
@Table(name = "payments")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    private String id;
    private ZonedDateTime dateCreated;
    
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;
    
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "idAdvertiser", nullable = false)
    private Advertiser advertiser;
    
    private double amount;

    public Payment(User user, Advertiser advertiser, double amount){
        this(UUID.randomUUID().toString(), ZonedDateTime.now(ZoneId.of("UTC+3")), user, advertiser, amount);
    }
}