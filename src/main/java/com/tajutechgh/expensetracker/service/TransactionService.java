package com.tajutechgh.expensetracker.service;

import com.tajutechgh.expensetracker.dto.TransactionDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TransactionService {

    public TransactionDto createTransaction(TransactionDto transactionDto);

    public Page<TransactionDto> getRecentTransactionsByUserId(int userId, int pageNum, int pageSize, String sortField);

    public TransactionDto updateTransaction(int transactionId, TransactionDto transactionDto);

    public void deleteTransactionById(int transactionId);

    public List<TransactionDto> getAllTransactionsByUserIdAndYear(int userId, int year);

    public List<TransactionDto> getAllTransactionsByUserIdAndYearAndMonth(int userId, int year, int month);

    public List<Integer> getDistinctTransactionYears(int userId);
}
