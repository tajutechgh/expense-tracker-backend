package com.tajutechgh.expensetracker.controller;

import com.tajutechgh.expensetracker.dto.TransactionCategoryDto;
import com.tajutechgh.expensetracker.service.TransactionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction-category")
public class TransactionCategoryController {

    @Autowired
    private TransactionCategoryService transactionCategoryService;

    //TODO: create transaction category
    @PostMapping("/create")
    public ResponseEntity<TransactionCategoryDto> createTransactionCategory(@RequestBody TransactionCategoryDto transactionCategoryDto){

        TransactionCategoryDto savedTransactionCategory = transactionCategoryService.createTransactionCategory(
                transactionCategoryDto.getUserId(),
                transactionCategoryDto.getCategoryName(),
                transactionCategoryDto.getCategoryColor()
        );

        return new ResponseEntity<>(savedTransactionCategory, HttpStatus.CREATED);
    }
}
