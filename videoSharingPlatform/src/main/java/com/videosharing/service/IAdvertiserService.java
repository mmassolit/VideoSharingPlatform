package com.videosharing.service;

import java.util.List;

import com.videosharing.model.Advertiser;

import javassist.NotFoundException;


public interface IAdvertiserService {
	List<Advertiser> findAll();

	Advertiser save(Advertiser advertiserForSave);
    
	Advertiser getById(String advertiserId) throws NotFoundException;

    void deleteById(String advertiserId) throws NotFoundException;
}
