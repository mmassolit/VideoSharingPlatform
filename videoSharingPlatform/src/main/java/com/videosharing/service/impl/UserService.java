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
import com.videosharing.api.dto.UserPayload;
import com.videosharing.model.Ad;
import com.videosharing.model.Advertiser;
import com.videosharing.model.Role;
import com.videosharing.model.User;
import com.videosharing.repository.UserRepository;
import com.videosharing.service.IUserService;

import javassist.NotFoundException;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
	private final RoleService roleService;
	
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }
    
    @Override
    public Page<User> findPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("dateCreated")));
    }
    
    @Override
    public User save(User userForSave) {
        return repository.save(userForSave);
    }

    @Override
    public User getById(String id) throws NotFoundException {
        Optional<User> tempUser = repository.findById(id);
        if (tempUser.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("User with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
    
    @Override
    public User addUser(UserPayload payload) throws NotFoundException {
        Role role = roleService.getById(payload.getRole());
        return save(new User(role, payload.getName(), payload.getPassword(), payload.getEmail()));
    }
    
    @Override
    public void updateBalance(String id, double amount) throws NotFoundException, IllegalArgumentException {
    	User user = getById(id);
    	double currentBalance = user.getBalance();
    	
    	if (currentBalance + amount < 0) {
    		throw new IllegalArgumentException("User doesn't have enough balance for this transaction.");
    	}
    	
    	user.setBalance(currentBalance + amount);
    }
}
