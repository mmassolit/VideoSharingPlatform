package com.videosharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "roles")

@EnableAutoConfiguration
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    @Id
    private String id;
    
    private String name;
    private boolean allowedAds;
    private boolean allowedVideos;
    
    public Role(String name, boolean allowedAds, boolean allowedVideos) { 
    	this(UUID.randomUUID().toString(), name, allowedAds, allowedVideos); 
    }
}