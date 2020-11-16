package com.videosharing.api.controller;

import javassist.NotFoundException;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.videosharing.VideoSharingPlatformApplication;
import com.videosharing.api.dto.RolePayload;
import com.videosharing.model.Role;
import com.videosharing.service.IRoleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("api/roles")
@AllArgsConstructor
public final class RoleController {
	static final Logger log = LoggerFactory.getLogger(VideoSharingPlatformApplication.class);
	
	@Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> index() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody RolePayload payload) {
    	Role newRole = new Role(payload.getName(), payload.isAllowedAds(), payload.isAllowedVideos());
        return ResponseEntity.ok(roleService.save(newRole));
    }

    @GetMapping("{roleId}")
    public ResponseEntity<Role> show(@PathVariable String roleId) throws NotFoundException {
        return ResponseEntity.ok(roleService.getById(roleId));
    }

    @DeleteMapping("{roleId}")
    public ResponseEntity<Void> delete(@PathVariable String roleId) throws NotFoundException {
    	roleService.deleteById(roleId);
        return ResponseEntity.noContent().build();
    }
    
    
}