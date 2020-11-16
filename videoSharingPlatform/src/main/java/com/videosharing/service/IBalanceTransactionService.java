package com.videosharing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.videosharing.api.dto.BalanceTransactionPayload;
import com.videosharing.model.BalanceTransaction;

import javassist.NotFoundException;


public interface IBalanceTransactionService {
	List<BalanceTransaction> findAll();

	Page<BalanceTransaction> findPaginated(int page, int size);
	
	BalanceTransaction save(BalanceTransaction balanceTransactionForSave);
    
	BalanceTransaction getById(String balanceTransactionId) throws NotFoundException;

    void deleteById(String balanceTransactionId) throws NotFoundException;
    
    BalanceTransaction addBalanceTransaction(BalanceTransactionPayload payload) throws NotFoundException, IllegalArgumentException;
}
