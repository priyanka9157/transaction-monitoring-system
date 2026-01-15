package com.transactionService.project.service;

import com.transactionService.project.model.Transaction;
import com.transactionService.project.repository.TransactionRepository;
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
