package com.tajutechgh.expensetracker.mapper;

import com.tajutechgh.expensetracker.dto.TransactionCategoryDto;
import com.tajutechgh.expensetracker.entity.TransactionCategory;

public class TransactionCategoryMapper {

    public static TransactionCategoryDto mapToTransactionCategoryDto(TransactionCategory transactionCategory){

        return new TransactionCategoryDto(
                transactionCategory.getId(),
                transactionCategory.getUser().getId(),
                transactionCategory.getCategoryName(),
                transactionCategory.getCategoryColor()
        );
    }

    public static TransactionCategory mapToTransactionCategory(TransactionCategoryDto transactionCategoryDto){

        TransactionCategory transactionCategory = new TransactionCategory();

        transactionCategory.setUser(transactionCategory.getUser());
        transactionCategory.setCategoryName(transactionCategoryDto.getCategoryName());
        transactionCategory.setCategoryColor(transactionCategory.getCategoryColor());

        return  transactionCategory;
    }
}
