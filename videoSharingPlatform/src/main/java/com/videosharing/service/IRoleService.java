package com.videosharing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.videosharing.model.Role;

import javassist.NotFoundException;


public interface IRoleService {	
	List<Role> findAll();

	Page<Role> findPaginated(int page, int size);
	
    Role save(Role adForSave);
    
    Role getById(String adId) throws NotFoundException;

    void deleteById(String adId) throws NotFoundException;
}
