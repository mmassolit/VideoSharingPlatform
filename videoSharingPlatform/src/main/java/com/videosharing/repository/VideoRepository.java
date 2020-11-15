package com.videosharing.repository;

import org.springframework.data.repository.CrudRepository;

import com.videosharing.model.Video;

public interface VideoRepository extends CrudRepository<Video, String>{
	
}
