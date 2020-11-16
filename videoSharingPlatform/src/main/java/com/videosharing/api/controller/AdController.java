package com.videosharing.api.controller;

import javassist.NotFoundException;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.videosharing.VideoSharingPlatformApplication;
import com.videosharing.api.dto.AdPayload;
import com.videosharing.model.Ad;
import com.videosharing.service.IAdService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("api/ads")
@AllArgsConstructor
public final class AdController {
	static final Logger log = LoggerFactory.getLogger(VideoSharingPlatformApplication.class);
	
	@Autowired
    private IAdService adService;

    @GetMapping
    public ResponseEntity<List<Ad>> index() {
        return ResponseEntity.ok(adService.findAll());
    }

    @PostMapping
    public ResponseEntity<Ad> create(@RequestBody AdPayload payload) throws NotFoundException {
    	return ResponseEntity.ok(adService.addAd(payload));
    }

    @GetMapping("{adId}")
    public ResponseEntity<Ad> show(@PathVariable String adId) throws NotFoundException {
        return ResponseEntity.ok(adService.getById(adId));
    }

    @DeleteMapping("{adId}")
    public ResponseEntity<Void> delete(@PathVariable String adId) throws NotFoundException {
    	adService.deleteById(adId);
        return ResponseEntity.noContent().build();
    }
}