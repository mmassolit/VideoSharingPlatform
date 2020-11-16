package com.videosharing.repository;

import org.springframework.data.repository.CrudRepository;

import com.videosharing.model.Playback;

public interface PlaybackRepository extends CrudRepository<Playback, String>{
	
}
