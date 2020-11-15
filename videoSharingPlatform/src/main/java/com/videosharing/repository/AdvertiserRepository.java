package com.videosharing.repository;

import org.springframework.data.repository.CrudRepository;

import com.videosharing.model.Advertiser;

public interface AdvertiserRepository extends CrudRepository<Advertiser, String>{
	
}
