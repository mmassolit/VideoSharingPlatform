package com.videosharing.service;

import java.util.List;

import com.videosharing.model.Ad;

import javassist.NotFoundException;


public interface IAdService {
	List<Ad> findAll();

    Ad save(Ad adForSave);
    
    Ad getById(String adId) throws NotFoundException;

    void deleteById(String adId) throws NotFoundException;
}
