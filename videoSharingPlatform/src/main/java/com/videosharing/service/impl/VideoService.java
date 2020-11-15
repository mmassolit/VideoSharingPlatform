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
import com.videosharing.model.Video;
import com.videosharing.repository.VideoRepository;
import com.videosharing.service.IVideoService;

import javassist.NotFoundException;

@Service
@AllArgsConstructor
public class VideoService implements IVideoService {
    @Autowired
    private VideoRepository repository;

    @Override
    public List<Video> findAll() {
        return (List<Video>) repository.findAll();
    }
    
    @Override
    public Page<Video> findPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("dateCreated")));
    }
    
    @Override
    public Video save(Video videoForSave) {
        return repository.save(videoForSave);
    }

    @Override
    public Video getById(String id) throws NotFoundException {
        Optional<Video> tempVideo = repository.findById(id);
        if (tempVideo.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Video with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
}
