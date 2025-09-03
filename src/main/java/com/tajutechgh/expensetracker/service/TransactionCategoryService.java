package com.tajutechgh.expensetracker.service;

import com.tajutechgh.expensetracker.dto.TransactionCategoryDto;

import java.util.List;

public interface TransactionCategoryService {

    public TransactionCategoryDto createTransactionCategory(int userId, String categoryName, String categoryColor);

    public List<TransactionCategoryDto> getAllTransactionCategoriesByUserId(int userId);

    public TransactionCategoryDto getTransactionCategoryById(int categoryId);

    public TransactionCategoryDto updateTransactionCategory(int categoryId, String categoryName, String categoryColor);

    public void deleteTransactionCategory(int categoryId);
}
