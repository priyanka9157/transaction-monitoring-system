package com.project.transaction_service.service;


import com.project.transaction_service.model.Transaction;
import com.project.transaction_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getByUserId(Long userId){
        return transactionRepository.findByUserId(userId);
    }
}
