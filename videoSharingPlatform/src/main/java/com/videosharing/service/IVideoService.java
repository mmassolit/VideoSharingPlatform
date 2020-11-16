package com.videosharing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.videosharing.api.dto.VideoPayload;
import com.videosharing.model.Video;

import javassist.NotFoundException;


public interface IVideoService {
	List<Video> findAll();

	Page<Video> findPaginated(int page, int size);
	
    Video save(Video videoForSave);
    
    Video getById(String videoId) throws NotFoundException;

    void deleteById(String videoId) throws NotFoundException;
    
    Video addVideo(VideoPayload payload) throws NotFoundException, IllegalArgumentException;
    
    void updateViews(String videoId) throws NotFoundException;
}
