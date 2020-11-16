package com.videosharing.api.controller;

import javassist.NotFoundException;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.videosharing.VideoSharingPlatformApplication;
import com.videosharing.api.dto.BalanceTransactionPayload;
import com.videosharing.model.BalanceTransaction;
import com.videosharing.service.IBalanceTransactionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("api/balance-transactions")
@AllArgsConstructor
public final class BalanceTransactionController {
	static final Logger log = LoggerFactory.getLogger(VideoSharingPlatformApplication.class);
	
	@Autowired
    private IBalanceTransactionService balanceTransactionService;

    @GetMapping
    public ResponseEntity<List<BalanceTransaction>> index() {
        return ResponseEntity.ok(balanceTransactionService.findAll());
    }

    @PostMapping
    public ResponseEntity<BalanceTransaction> create(@RequestBody BalanceTransactionPayload payload) throws NotFoundException {
        return ResponseEntity.ok(balanceTransactionService.addBalanceTransaction(payload));
    }

    @GetMapping("{balanceTransactionId}")
    public ResponseEntity<BalanceTransaction> show(@PathVariable String balanceTransactionId) throws NotFoundException {
        return ResponseEntity.ok(balanceTransactionService.getById(balanceTransactionId));
    }

    @DeleteMapping("{balanceTransactionId}")
    public ResponseEntity<Void> delete(@PathVariable String balanceTransactionId) throws NotFoundException {
    	balanceTransactionService.deleteById(balanceTransactionId);
        return ResponseEntity.noContent().build();
    }
}