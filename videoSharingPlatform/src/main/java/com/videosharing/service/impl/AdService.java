package com.videosharing.service.impl;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videosharing.model.Ad;
import com.videosharing.repository.AdRepository;
import com.videosharing.service.IAdService;

import javassist.NotFoundException;

@Service
@AllArgsConstructor
public class AdService implements IAdService {
    @Autowired
    private AdRepository repository;

    @Override
    public List<Ad> findAll() {
        return (List<Ad>) repository.findAll();
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
}
