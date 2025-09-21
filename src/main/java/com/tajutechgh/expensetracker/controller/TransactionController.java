package com.tajutechgh.expensetracker.controller;

import com.tajutechgh.expensetracker.dto.TransactionDto;
import com.tajutechgh.expensetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // TODO: get recent transactions by user
    @GetMapping("/recent/user/{userId}")
    public  ResponseEntity<List<TransactionDto>> getRecentTransactionsByUserId(
            @PathVariable(name = "userId") Integer userId,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "size", required = false, defaultValue = "5") Integer pageSize,
            @RequestParam(value = "sort", required = false, defaultValue = "transactionDate") String sortOption ){

        Page<TransactionDto> page = transactionService.getRecentTransactionsByUserId(userId, pageNum, pageSize, sortOption);

        List<TransactionDto> transactionDtos = page.getContent();

        if (transactionDtos.isEmpty()){

            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity<>(transactionDtos, HttpStatus.OK);
    }

    // TODO: update transaction
    @PutMapping("/update/{transactionId}")
    public ResponseEntity<TransactionDto> updateTransaction(@PathVariable(name = "transactionId") int transactionId,
                                                            @RequestBody TransactionDto transactionDto){

        TransactionDto updatedTransactionDto = transactionService.updateTransaction(transactionId, transactionDto);

        return new ResponseEntity<>(updatedTransactionDto, HttpStatus.OK);
    }

    // TODO: delete transaction by id
    @DeleteMapping("/delete/{transactionId}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable(name = "transactionId") int transactionId){

        transactionService.deleteTransactionById(transactionId);

        return ResponseEntity.ok("Transaction deleted successfully!");
    }

    //TODO: get all transactions by user id and year
    @GetMapping("/user-year/{userId}")
    public ResponseEntity<List<TransactionDto>> getAllTransactionsByUserIdAndYearOrMonth(@PathVariable(name = "userId") int userId, @RequestParam int year,
                                                                                  @RequestParam(required = false) Integer month){

        List<TransactionDto> transactionDtoList =  null;

        if (month == null){

            transactionDtoList = transactionService.getAllTransactionsByUserIdAndYear(userId, year);

        }else {

            transactionDtoList = transactionService.getAllTransactionsByUserIdAndYearAndMonth(userId, year, month);
        }

        return new ResponseEntity<>(transactionDtoList, HttpStatus.OK);
    }

    //TODO: get distinct transaction years
    @GetMapping("/distinct/years/{userId}")
    public ResponseEntity<List<Integer>> getDistinctTransactionYears(@PathVariable(name = "userId") int userId){

        List<Integer> distinctTransactionYears = transactionService.getDistinctTransactionYears(userId);

        return new ResponseEntity<>(distinctTransactionYears, HttpStatus.OK);
    }
}
