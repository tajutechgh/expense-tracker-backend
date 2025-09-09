package com.tajutechgh.expensetracker.mapper;

import com.tajutechgh.expensetracker.dto.TransactionDto;
import com.tajutechgh.expensetracker.entity.Transaction;

public class TransactionMapper {

    public static TransactionDto mapToTransactionDto(Transaction transaction){

        return new TransactionDto(
                transaction.getId(),
                transaction.getUser().getId(),
                transaction.getTransactionCategory().getId(),
                transaction.getTransactionName(),
                transaction.getTransactionAmount(),
                transaction.getTransactionDate(),
                transaction.getTransactionType()
        );
    }

    public static Transaction mapToTransaction(TransactionDto transactionDto){

        Transaction transaction = new Transaction();

        transaction.setUser(transaction.getUser());
        transaction.setTransactionCategory(transaction.getTransactionCategory());
        transaction.setTransactionName(transactionDto.getTransactionName());
        transaction.setTransactionAmount(transactionDto.getTransactionAmount());
        transaction.setTransactionDate(transactionDto.getTransactionDate());
        transaction.setTransactionType(transactionDto.getTransactionType());

        return transaction;
    }
}
