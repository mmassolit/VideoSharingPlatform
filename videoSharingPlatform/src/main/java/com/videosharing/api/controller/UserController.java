package com.videosharing.api.controller;

import javassist.NotFoundException;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.videosharing.VideoSharingPlatformApplication;
import com.videosharing.api.dto.UserPayload;
import com.videosharing.model.User;
import com.videosharing.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public final class UserController {
	static final Logger log = LoggerFactory.getLogger(VideoSharingPlatformApplication.class);
	
	@Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<List<User>> index() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserPayload payload) throws NotFoundException {
        return ResponseEntity.ok(userService.addUser(payload));
    }

    @GetMapping("{userId}")
    public ResponseEntity<User> show(@PathVariable String userId) throws NotFoundException {
        return ResponseEntity.ok(userService.getById(userId));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> delete(@PathVariable String userId) throws NotFoundException {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
}