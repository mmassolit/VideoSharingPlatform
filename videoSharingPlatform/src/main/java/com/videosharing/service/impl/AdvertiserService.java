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
import com.videosharing.model.Advertiser;
import com.videosharing.repository.AdvertiserRepository;
import com.videosharing.service.IAdvertiserService;

import javassist.NotFoundException;

@Service
@AllArgsConstructor
public class AdvertiserService implements IAdvertiserService {
    @Autowired
    private AdvertiserRepository repository;

    @Override
    public List<Advertiser> findAll() {
        return (List<Advertiser>) repository.findAll();
    }
    
    @Override
    public Page<Advertiser> findPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("dateCreated")));
    }
    
    @Override
    public Advertiser save(Advertiser advertiserForSave) {
        return repository.save(advertiserForSave);
    }

    @Override
    public Advertiser getById(String id) throws NotFoundException {
        Optional<Advertiser> tempAdvertiser = repository.findById(id);
        if (tempAdvertiser.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Advertiser with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
}
