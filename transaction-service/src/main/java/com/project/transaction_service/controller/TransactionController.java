package com.project.transaction_service.controller;

import com.project.transaction_service.service.TransactionService;
import com.project.transaction_service.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public Transaction create(@RequestBody Transaction transaction){
        return transactionService.save(transaction);
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getByUserId(@PathVariable Long userId){
        return transactionService.getByUserId(userId);

    }
}
