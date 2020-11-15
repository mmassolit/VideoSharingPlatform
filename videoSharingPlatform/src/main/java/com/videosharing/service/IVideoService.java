package com.videosharing.service;

import java.util.List;

import com.videosharing.model.Video;

import javassist.NotFoundException;


public interface IVideoService {
	List<Video> findAll();

    Video save(Video videoForSave);
    
    Video getById(String videoId) throws NotFoundException;

    void deleteById(String videoId) throws NotFoundException;
}
