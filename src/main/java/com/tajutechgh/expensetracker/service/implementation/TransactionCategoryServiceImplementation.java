package com.tajutechgh.expensetracker.service.implementation;

import com.tajutechgh.expensetracker.dto.TransactionCategoryDto;
import com.tajutechgh.expensetracker.entity.TransactionCategory;
import com.tajutechgh.expensetracker.entity.User;
import com.tajutechgh.expensetracker.exception.TransactionCategoryNotFoundException;
import com.tajutechgh.expensetracker.exception.UserNotFoundException;
import com.tajutechgh.expensetracker.mapper.TransactionCategoryMapper;
import com.tajutechgh.expensetracker.repository.TransactionCategoryRepository;
import com.tajutechgh.expensetracker.repository.UserRepository;
import com.tajutechgh.expensetracker.service.TransactionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    @Override
    public List<TransactionCategoryDto> getAllTransactionCategoriesByUserId(int userId) {

        logger.info("Getting all transaction categories by user ID: " + userId);

        List<TransactionCategory> transactionCategories = transactionCategoryRepository.findAllByUserId(userId);

        if (transactionCategories.isEmpty()){

            throw new TransactionCategoryNotFoundException("Transaction categories by user ID: " + userId + " not found");
        }

        return transactionCategories.stream().map((transactionCategory) -> TransactionCategoryMapper.mapToTransactionCategoryDto(transactionCategory)).collect(Collectors.toList());
    }

    @Override
    public TransactionCategoryDto getTransactionCategoryById(int categoryId) {

        TransactionCategory transactionCategory = transactionCategoryRepository.findById(categoryId).orElseThrow(

                () -> new TransactionCategoryNotFoundException("Transaction category with ID " + categoryId + " not found")
        );

        return TransactionCategoryMapper.mapToTransactionCategoryDto(transactionCategory);
    }

    @Override
    public TransactionCategoryDto updateTransactionCategory(int categoryId, String categoryName, String categoryColor) {

        TransactionCategory transactionCategory = transactionCategoryRepository.findById(categoryId).orElseThrow(

                () -> new TransactionCategoryNotFoundException("Transaction category with ID " + categoryId + " not found")
        );

        transactionCategory.setCategoryName(categoryName);
        transactionCategory.setCategoryColor(categoryColor);

        TransactionCategory updatedCategory = transactionCategoryRepository.save(transactionCategory);

        return TransactionCategoryMapper.mapToTransactionCategoryDto(updatedCategory);
    }

    @Override
    public void deleteTransactionCategory(int categoryId) {

        TransactionCategory transactionCategory = transactionCategoryRepository.findById(categoryId).orElseThrow(

                () -> new TransactionCategoryNotFoundException("Transaction category with ID " + categoryId + " not found")
        );

        transactionCategoryRepository.deleteById(categoryId);
    }
}
