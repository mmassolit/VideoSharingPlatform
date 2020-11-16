package com.videosharing.service.impl;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.videosharing.api.dto.BalanceTransactionPayload;
import com.videosharing.model.BalanceTransaction;
import com.videosharing.model.User;
import com.videosharing.repository.BalanceTransactionRepository;
import com.videosharing.service.IBalanceTransactionService;

import javassist.NotFoundException;

@Service
@AllArgsConstructor
public class BalanceTransactionService implements IBalanceTransactionService {
	private final UserService userService;
	
    @Autowired
    private BalanceTransactionRepository repository;

    @Override
    public List<BalanceTransaction> findAll() {
        return (List<BalanceTransaction>) repository.findAll();
    }
    
    @Override
    public Page<BalanceTransaction> findPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("dateCreated")));
    }
    
    @Override
    public BalanceTransaction save(BalanceTransaction balanceTransactionForSave) {
        return repository.save(balanceTransactionForSave);
    }

    @Override
    public BalanceTransaction getById(String id) throws NotFoundException {
        Optional<BalanceTransaction> tempBalanceTransaction = repository.findById(id);
        if (tempBalanceTransaction.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("BalanceTransaction with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
    
    @Override
    public BalanceTransaction addBalanceTransaction(BalanceTransactionPayload payload) throws NotFoundException, IllegalArgumentException {
    	User user = userService.getById(payload.getUser());
    	
    	userService.updateBalance(payload.getUser(), payload.getAmount());
    	
        return save(new BalanceTransaction(user, payload.getAmount()));
    }   
}
