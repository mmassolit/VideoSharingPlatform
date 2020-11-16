package com.videosharing.api.controller;

import javassist.NotFoundException;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.videosharing.VideoSharingPlatformApplication;
import com.videosharing.api.dto.PaymentPayload;
import com.videosharing.model.Payment;
import com.videosharing.service.IPaymentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("api/payments")
@AllArgsConstructor
public final class PaymentController {
	static final Logger log = LoggerFactory.getLogger(VideoSharingPlatformApplication.class);
	
	@Autowired
    private IPaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> index() {
        return ResponseEntity.ok(paymentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody PaymentPayload payload) throws NotFoundException {
        return ResponseEntity.ok(paymentService.addPayment(payload.getUserFrom(), payload.getUserTo(), payload.getAmount()));
    }

    @GetMapping("{paymentId}")
    public ResponseEntity<Payment> show(@PathVariable String paymentId) throws NotFoundException {
        return ResponseEntity.ok(paymentService.getById(paymentId));
    }

    @DeleteMapping("{paymentId}")
    public ResponseEntity<Void> delete(@PathVariable String paymentId) throws NotFoundException {
        paymentService.deleteById(paymentId);
        return ResponseEntity.noContent().build();
    }
}