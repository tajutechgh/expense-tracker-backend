package com.tajutechgh.expensetracker.service.implementation;

import com.tajutechgh.expensetracker.dto.TransactionDto;
import com.tajutechgh.expensetracker.entity.Transaction;
import com.tajutechgh.expensetracker.entity.TransactionCategory;
import com.tajutechgh.expensetracker.entity.User;
import com.tajutechgh.expensetracker.exception.TransactionCategoryNotFoundException;
import com.tajutechgh.expensetracker.exception.TransactionNotFoundException;
import com.tajutechgh.expensetracker.exception.UserNotFoundException;
import com.tajutechgh.expensetracker.mapper.TransactionMapper;
import com.tajutechgh.expensetracker.repository.TransactionCategoryRepository;
import com.tajutechgh.expensetracker.repository.TransactionRepository;
import com.tajutechgh.expensetracker.repository.UserRepository;
import com.tajutechgh.expensetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TransactionServiceImplementation implements TransactionService {

    private static final Logger logger = Logger.getLogger(TransactionServiceImplementation.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {

        logger.info("Creating Transaction");

        Transaction transaction = TransactionMapper.mapToTransaction(transactionDto);

        TransactionCategory transactionCategory = transactionCategoryRepository.findById(transactionDto.getCategoryId()).orElseThrow(

                () -> new TransactionCategoryNotFoundException("Category with ID: " + transactionDto.getCategoryId() + " not found!")
        );

        User user = userRepository.findById(transactionDto.getUserId()).orElseThrow(

                () -> new UserNotFoundException("User with ID: " + transactionDto.getUserId() + " not found!")
        );

        transaction.setTransactionCategory(transactionCategory);
        transaction.setUser(user);

        Transaction savedTransaction = transactionRepository.save(transaction);

        return TransactionMapper.mapToTransactionDto(savedTransaction);
    }

    @Override
    public Page<TransactionDto> getRecentTransactionsByUserId(int userId, int pageNum, int pageSize, String sortField) {

        Sort sort = Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);

        return transactionRepository.findAllByUserId(userId, pageable).map(TransactionMapper::mapToTransactionDto);
    }

    @Override
    public void deleteTransactionById(int transactionId) {

        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(

                () -> new TransactionNotFoundException("Transaction with ID: " + transactionId + " not found!")
        );

        transactionRepository.deleteById(transactionId);
    }
}
