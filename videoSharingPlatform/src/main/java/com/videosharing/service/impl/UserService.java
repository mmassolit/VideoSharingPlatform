package com.videosharing.service.impl;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.videosharing.model.Ad;
import com.videosharing.model.User;
import com.videosharing.repository.UserRepository;
import com.videosharing.service.IUserService;

import javassist.NotFoundException;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
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
}
