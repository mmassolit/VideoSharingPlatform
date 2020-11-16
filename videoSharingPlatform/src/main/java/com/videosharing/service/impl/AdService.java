package com.videosharing.service.impl;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.videosharing.api.dto.AdPayload;
import com.videosharing.model.Ad;
import com.videosharing.model.Role;
import com.videosharing.model.User;
import com.videosharing.repository.AdRepository;
import com.videosharing.service.IAdService;

import javassist.NotFoundException;

@Service
@AllArgsConstructor
public class AdService implements IAdService {
	private final UserService userService;
	
    @Autowired
    private AdRepository repository;
    
    @Override
    public List<Ad> findAll() {
        return (List<Ad>) repository.findAll();
    }
    
    @Override
    public Page<Ad> findPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("dateCreated")));
    }

    @Override
    public Ad save(Ad adForSave) {
        return repository.save(adForSave);
    }

    @Override
    public Ad getById(String id) throws NotFoundException {
        Optional<Ad> tempAd = repository.findById(id);
        if (tempAd.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Ad with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
    
    @Override
    public Ad addAd(AdPayload payload) throws NotFoundException, IllegalArgumentException {
        User user = userService.getById(payload.getUser());
        Role role = user.getRole();
        
        if (!role.isAllowedAds()){
        	throw new IllegalArgumentException("User doesn't have permission to create ads.");
        }
        
        if (user.getBalance() < payload.getBudget()){
        	throw new IllegalArgumentException("User's balance is to small for this budget.");
        }
        
        return save(new Ad(payload.getCpm(), payload.getBudget(), user));
    }
    
    @Override
    public Ad pickAd() {
    	List<Ad> adList = findAll();
    	
    	double maxCpm = adList.get(0).getCpm();
    	int maxIndex = 0;
    	
    	 for (int i = 0; i < adList.size(); i++) {
    		 double cpm = adList.get(i).getCpm();
    		 double budget = adList.get(i).getBudget();
    		 
             if (cpm > maxCpm && cpm <= budget) {
            	 maxIndex = i;
            	 maxCpm = cpm;
             }
         }
    	 
    	 return adList.get(maxIndex);
    }
    
    @Override
    public void updateBudget(String id, double amount) throws NotFoundException, IllegalArgumentException {
    	Ad ad = getById(id);
    	double currentBudget = ad.getBudget();
    	
    	if (currentBudget + amount < 0) {
    		throw new IllegalArgumentException("Ad doesn't have enough budget for this transaction.");
    	}
    	
    	ad.setBudget(currentBudget + amount);
    }
}
