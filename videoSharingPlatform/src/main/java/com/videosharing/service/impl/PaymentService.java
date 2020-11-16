package com.videosharing.service.impl;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.videosharing.api.dto.PaymentPayload;
import com.videosharing.model.Ad;
import com.videosharing.model.Payment;
import com.videosharing.model.User;
import com.videosharing.repository.PaymentRepository;
import com.videosharing.service.IPaymentService;

import javassist.NotFoundException;

@Service
@AllArgsConstructor
public class PaymentService implements IPaymentService {
	private final UserService userService;
	
    @Autowired
    private PaymentRepository repository;

    @Override
    public List<Payment> findAll() {
        return (List<Payment>) repository.findAll();
    }
    
    @Override
    public Page<Payment> findPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("dateCreated")));
    }
    
    @Override
    public Payment save(Payment paymentForSave) {
        return repository.save(paymentForSave);
    }

    @Override
    public Payment getById(String id) throws NotFoundException {
        Optional<Payment> tempPayment = repository.findById(id);
        if (tempPayment.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Payment with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
    
    @Override
    public Payment addPayment(String idUserFrom, String idUserTo, double amount) throws NotFoundException, IllegalArgumentException {
    	User userFrom = userService.getById(idUserFrom);
    	User userTo = userService.getById(idUserTo);
    	
    	if (userFrom == userTo) {
    		throw new IllegalArgumentException("Users are equal.");
    	}
    	
    	userService.updateBalance(idUserFrom, -amount);
    	userService.updateBalance(idUserTo, amount);
    	
        return save(new Payment(userFrom, userTo, amount));
    }
    
    
}
