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
import com.videosharing.model.Payment;
import com.videosharing.model.User;
import com.videosharing.repository.PaymentRepository;
import com.videosharing.service.IPaymentService;

import javassist.NotFoundException;

@Service
@AllArgsConstructor
public class PaymentService implements IPaymentService {
    @Autowired
    private PaymentRepository repository;

    @Override
    public List<Paymentr> findAll() {
        return (List<Payment>) repository.findAll();
    }
    
    @Override
    public Page<Payment> findPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("dateCreated")));
    }
    
    @Override
    public Payment save(User paymentForSave) {
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
}
