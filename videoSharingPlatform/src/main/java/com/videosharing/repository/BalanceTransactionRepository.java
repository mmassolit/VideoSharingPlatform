package com.videosharing.repository;

import org.springframework.data.repository.CrudRepository;

import com.videosharing.model.BalanceTransaction;

public interface BalanceTransactionRepository extends CrudRepository<BalanceTransaction, String>{
	
}
