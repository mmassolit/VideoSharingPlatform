package com.videosharing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.videosharing.api.dto.PaymentPayload;
import com.videosharing.model.Payment;

import javassist.NotFoundException;


public interface IPaymentService {
	List<Payment> findAll();

	Page<Payment> findPaginated(int page, int size);
	
	Payment save(Payment paymentForSave);
    
	Payment getById(String paymentId) throws NotFoundException;

    void deleteById(String paymentId) throws NotFoundException;
    
    Payment addPayment(String idUserFrom, String idUserTo, double amount) throws NotFoundException, IllegalArgumentException;
}
