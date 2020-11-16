package com.videosharing.service.impl;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.videosharing.api.dto.PlaybackPayload;
import com.videosharing.model.Ad;
import com.videosharing.model.Payment;
import com.videosharing.model.Playback;
import com.videosharing.model.User;
import com.videosharing.model.Video;
import com.videosharing.repository.PlaybackRepository;
import com.videosharing.service.IPlaybackService;

import javassist.NotFoundException;

@Service
@AllArgsConstructor
public class PlaybackService implements IPlaybackService {
	private final UserService userService;
	private final VideoService videoService;
	private final AdService adService;
	private final PaymentService paymentService;
	
    @Autowired
    private PlaybackRepository repository;

    @Override
    public List<Playback> findAll() {
        return (List<Playback>) repository.findAll();
    }
    
    @Override
    public Page<Playback> findPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("dateCreated")));
    }
    
    @Override
    public Playback save(Playback playbackForSave) {
        return repository.save(playbackForSave);
    }

    @Override
    public Playback getById(String id) throws NotFoundException {
        Optional<Playback> tempPlayback = repository.findById(id);
        if (tempPlayback.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Playback with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
    
    @Override
    public Playback addPlayback(String idUser, String idVideo, String idAd) throws NotFoundException, IllegalArgumentException {
    	User user = userService.getById(idUser);
    	Video video = videoService.getById(idVideo);
    	Ad ad = adService.getById(idAd);
    	
    	String idVideoCreator = video.getUser().getId();
    	String idAdCreator = ad.getUser().getId();
    	
    	double costPerView = ad.getCpm() / 1000;
    	
    	videoService.updateViews(idVideo);
    	adService.updateBudget(idAd, - costPerView);
    	paymentService.addPayment(idAdCreator, idVideoCreator, costPerView);
    	
        return save(new Playback(user, video, ad));
    }
    
    
}
