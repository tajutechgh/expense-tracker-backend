package com.tajutechgh.expensetracker.service.implementation;

import com.tajutechgh.expensetracker.dto.TransactionCategoryDto;
import com.tajutechgh.expensetracker.entity.TransactionCategory;
import com.tajutechgh.expensetracker.entity.User;
import com.tajutechgh.expensetracker.exception.UserNotFoundException;
import com.tajutechgh.expensetracker.mapper.TransactionCategoryMapper;
import com.tajutechgh.expensetracker.repository.TransactionCategoryRepository;
import com.tajutechgh.expensetracker.repository.UserRepository;
import com.tajutechgh.expensetracker.service.TransactionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TransactionCategoryServiceImplementation implements TransactionCategoryService {

    private static final Logger logger = Logger.getLogger(TransactionCategoryServiceImplementation.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    @Override
    public TransactionCategoryDto createTransactionCategory(int userId, String categoryName, String categoryColor) {

        logger.info("Getting user by user ID: " + userId);

        User user = userRepository.findById(userId).orElseThrow(

                () -> new UserNotFoundException("User with ID " + userId + " not found!")
        );

        TransactionCategory transactionCategory = new TransactionCategory();

        transactionCategory.setUser(user);
        transactionCategory.setCategoryName(categoryName);
        transactionCategory.setCategoryColor(categoryColor);

        TransactionCategory savedTransactionCategory = transactionCategoryRepository.save(transactionCategory);

        return TransactionCategoryMapper.mapToTransactionCategoryDto(savedTransactionCategory);
    }
}
