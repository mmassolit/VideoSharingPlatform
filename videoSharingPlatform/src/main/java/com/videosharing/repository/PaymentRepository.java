package com.videosharing.repository;

import org.springframework.data.repository.CrudRepository;

import com.videosharing.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, String>{
	
}
