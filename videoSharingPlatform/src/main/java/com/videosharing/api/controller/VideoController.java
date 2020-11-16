package com.videosharing.api.controller;

import javassist.NotFoundException;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.videosharing.VideoSharingPlatformApplication;
import com.videosharing.api.dto.VideoPayload;
import com.videosharing.model.Video;
import com.videosharing.service.IVideoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("api/videos")
@AllArgsConstructor
public final class VideoController {
	static final Logger log = LoggerFactory.getLogger(VideoSharingPlatformApplication.class);
	
	@Autowired
    private IVideoService videoService;

    @GetMapping
    public ResponseEntity<List<Video>> index() {
        return ResponseEntity.ok(videoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Video> create(@RequestBody VideoPayload payload) throws NotFoundException {
    	return ResponseEntity.ok(videoService.addVideo(payload));
    }

    @GetMapping("{videoId}")
    public ResponseEntity<Video> show(@PathVariable String videoId) throws NotFoundException {
        return ResponseEntity.ok(videoService.getById(videoId));
    }

    @DeleteMapping("{videoId}")
    public ResponseEntity<Void> delete(@PathVariable String videoId) throws NotFoundException {
    	videoService.deleteById(videoId);
        return ResponseEntity.noContent().build();
    }
}