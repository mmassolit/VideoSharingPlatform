package com.videosharing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.videosharing.model.User;

import javassist.NotFoundException;


public interface IUserService {
	List<User> findAll();
	
	Page<User> findPaginated(int page, int size);
	
	User save(User userForSave);
    
	User getById(String userId) throws NotFoundException;

    void deleteById(String userId) throws NotFoundException;
}
