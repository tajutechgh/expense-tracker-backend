package com.tajutechgh.expensetracker.controller;

import com.tajutechgh.expensetracker.dto.TransactionCategoryDto;
import com.tajutechgh.expensetracker.service.TransactionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //TODO: list transaction categories by a user id
    @GetMapping("/user/all/{userId}")
    public ResponseEntity<List<TransactionCategoryDto>> getAllTransactionCategoriesByUser(@PathVariable("userId") int userId){

        List<TransactionCategoryDto> transactionCategoryDtos = transactionCategoryService.getAllTransactionCategoriesByUserId(userId);

        return ResponseEntity.ok(transactionCategoryDtos);
    }

    //TODO: get transaction category by id
    @GetMapping("/get/{categoryId}")
    public ResponseEntity<TransactionCategoryDto> getTransactionCategoryById(@PathVariable("categoryId") int categoryId){

        TransactionCategoryDto transactionCategory = transactionCategoryService.getTransactionCategoryById(categoryId);

        return new ResponseEntity<>(transactionCategory, HttpStatus.OK);
    }

    //TODO: update transaction category
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<TransactionCategoryDto> updateTransactionCategory(@PathVariable("categoryId") int categoryId,
                                                                            @RequestParam String categoryName, @RequestParam String categoryColor){

        TransactionCategoryDto updatedTransactionCategory = transactionCategoryService.updateTransactionCategory(
                categoryId,
                categoryName,
                categoryColor
        );

        return new ResponseEntity<>(updatedTransactionCategory, HttpStatus.OK);
    }

    //TODO: delete transaction category
    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<String> deleteTransactionCategory(@PathVariable("categoryId") int categoryId){

        transactionCategoryService.deleteTransactionCategory(categoryId);

        return ResponseEntity.ok("Transaction category deleted successfully");
    }
}
