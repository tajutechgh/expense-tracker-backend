package com.tajutechgh.expensetracker.controller;

import com.tajutechgh.expensetracker.dto.TransactionDto;
import com.tajutechgh.expensetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // TODO: create transaction
    @PostMapping("/create")
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto){

        TransactionDto savedTransaction = transactionService.createTransaction(transactionDto);

        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }
}
