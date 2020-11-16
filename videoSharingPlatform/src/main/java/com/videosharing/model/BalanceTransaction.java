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
@Table(name = "balance_transactions")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceTransaction {
    @Id
    private String id;
    private ZonedDateTime dateCreated;
    
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;
    
    private double amount;

    public BalanceTransaction(User user, double amount){
        this(UUID.randomUUID().toString(), ZonedDateTime.now(ZoneId.of("UTC+3")), user, amount);
    }
}