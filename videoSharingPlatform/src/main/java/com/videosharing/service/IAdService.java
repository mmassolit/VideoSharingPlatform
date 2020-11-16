package com.videosharing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.videosharing.api.dto.AdPayload;
import com.videosharing.model.Ad;

import javassist.NotFoundException;


public interface IAdService {	
	List<Ad> findAll();

	Page<Ad> findPaginated(int page, int size);
	
    Ad save(Ad adForSave);
    
    Ad getById(String adId) throws NotFoundException;

    void deleteById(String adId) throws NotFoundException;
    
    Ad addAd(AdPayload payload) throws NotFoundException, IllegalArgumentException;
    
    Ad pickAd();
    
    void updateBudget(String adId, double amount) throws NotFoundException, IllegalArgumentException;
}
