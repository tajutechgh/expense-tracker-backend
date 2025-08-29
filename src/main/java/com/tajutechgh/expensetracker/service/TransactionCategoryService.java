package com.tajutechgh.expensetracker.service;

import com.tajutechgh.expensetracker.dto.TransactionCategoryDto;

public interface TransactionCategoryService {

    public TransactionCategoryDto createTransactionCategory(int userId, String categoryName, String categoryColor);
}
