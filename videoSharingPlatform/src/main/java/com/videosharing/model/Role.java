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
    private String role_id;
    
    private String name;
    private String type;

    public Role(String name, String type) { 
    	this(UUID.randomUUID().toString(), name, type); 
    }
}