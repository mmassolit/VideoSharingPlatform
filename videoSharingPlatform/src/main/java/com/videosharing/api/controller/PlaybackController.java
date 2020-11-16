package com.videosharing.api.controller;

import javassist.NotFoundException;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.videosharing.VideoSharingPlatformApplication;
import com.videosharing.api.dto.PlaybackPayload;
import com.videosharing.model.Playback;
import com.videosharing.service.IPlaybackService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("api/playbacks")
@AllArgsConstructor
public final class PlaybackController {
	static final Logger log = LoggerFactory.getLogger(VideoSharingPlatformApplication.class);
	
	@Autowired
    private IPlaybackService playbackService;

    @GetMapping
    public ResponseEntity<List<Playback>> index() {
        return ResponseEntity.ok(playbackService.findAll());
    }

    @PostMapping
    public ResponseEntity<Playback> create(@RequestBody PlaybackPayload payload) throws NotFoundException {
        return ResponseEntity.ok(playbackService.addPlayback(payload));
    }

    @GetMapping("{playbackId}")
    public ResponseEntity<Playback> show(@PathVariable String playbackId) throws NotFoundException {
        return ResponseEntity.ok(playbackService.getById(playbackId));
    }

    @DeleteMapping("{playbackId}")
    public ResponseEntity<Void> delete(@PathVariable String playbackId) throws NotFoundException {
    	playbackService.deleteById(playbackId);
        return ResponseEntity.noContent().build();
    }
}