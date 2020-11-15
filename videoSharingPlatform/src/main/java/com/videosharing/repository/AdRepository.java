package com.videosharing.repository;

import org.springframework.data.repository.CrudRepository;

import com.videosharing.model.Ad;

public interface AdRepository extends CrudRepository<Ad, String>{
	
}
