package com.videosharing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.videosharing.model.Advertiser;

import javassist.NotFoundException;


public interface IAdvertiserService {
	List<Advertiser> findAll();

	Page<Advertiser> findPaginated(int page, int size);
	
	Advertiser save(Advertiser advertiserForSave);
    
	Advertiser getById(String advertiserId) throws NotFoundException;

    void deleteById(String advertiserId) throws NotFoundException;
}
