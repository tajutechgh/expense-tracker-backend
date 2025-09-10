package com.tajutechgh.expensetracker.service;

import com.tajutechgh.expensetracker.dto.TransactionDto;

public interface TransactionService {

    public TransactionDto createTransaction(TransactionDto transactionDto);
}
