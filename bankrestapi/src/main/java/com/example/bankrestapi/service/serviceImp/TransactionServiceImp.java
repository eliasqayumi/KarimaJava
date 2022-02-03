package com.example.bankrestapi.service.serviceImp;

import com.example.bankrestapi.model.Transaction;
import com.example.bankrestapi.repository.TransactionRepository;
import com.example.bankrestapi.service.service.TransactionService;

import java.util.List;

public class TransactionServiceImp implements TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void createTransaction(Transaction transaction) {

    }

    @Override
    public void deleteTransaction(Long transactionId) {

    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public Transaction findByTransactionId(Long transactionId) {
        return null;
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return null;
    }
}
