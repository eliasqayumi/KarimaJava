package com.example.bankrestapi.service.service;

import com.example.bankrestapi.model.Transaction;
import java.util.List;

public interface TransactionService {
    void createTransaction(Transaction transaction);
    void deleteTransaction(Long transactionId);
    Transaction updateTransaction(Transaction transaction);
    Transaction findByTransactionId(Long transactionId);
    List<Transaction> findAllTransaction();

}
