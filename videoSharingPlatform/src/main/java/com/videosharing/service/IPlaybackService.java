package com.videosharing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.videosharing.model.Playback;

import javassist.NotFoundException;


public interface IPlaybackService {
	List<Playback> findAll();

	Page<Playback> findPaginated(int page, int size);
	
    Playback save(Playback playbackForSave);
    
    Playback getById(String videoId) throws NotFoundException;

    void deleteById(String playbackId) throws NotFoundException;
    
    Playback addPlayback(String userId, String videoId, String adId) throws NotFoundException, IllegalArgumentException;
}
