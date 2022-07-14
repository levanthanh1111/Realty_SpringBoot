package com.example.land.service.Impl;

import com.example.land.entity.Transaction;
import com.example.land.repository.TransactionRepository;
import com.example.land.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.getById(id);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction, Long id) {
        Transaction t = transactionRepository.getById(id);

        t.setBuyerId(transaction.getBuyerId());
        t.setCommissionMoney(transaction.getCommissionMoney());
        t.setOwnerId(transaction.getOwnerId());
        t.setPlotId(transaction.getPlotId());
        return transactionRepository.save(t);
    }

    @Override
    public Boolean deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
        return true;
    }
}
