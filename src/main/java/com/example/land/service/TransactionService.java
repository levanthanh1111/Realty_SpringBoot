package com.example.land.service;

import com.example.land.entity.Role;
import com.example.land.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();
    Transaction getTransaction(Long id);
    Transaction createTransaction(Transaction transaction);
    Transaction updateTransaction(Transaction transaction, Long id);
    Boolean deleteTransaction(Long id);
}
