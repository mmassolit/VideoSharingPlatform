package com.videosharing.service.impl;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.videosharing.model.Role;
import com.videosharing.repository.RoleRepository;
import com.videosharing.service.IRoleService;

import javassist.NotFoundException;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository repository;
    
    @Override
    public List<Role> findAll() {
        return (List<Role>) repository.findAll();
    }
    
    @Override
    public Page<Role> findPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("dateCreated")));
    }

    @Override
    public Role save(Role roleForSave) {
        return repository.save(roleForSave);
    }

    @Override
    public Role getById(String id) throws NotFoundException {
        Optional<Role> tempAd = repository.findById(id);
        if (tempAd.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Role with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
}
