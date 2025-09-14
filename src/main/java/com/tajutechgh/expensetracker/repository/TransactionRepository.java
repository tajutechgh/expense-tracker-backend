package com.tajutechgh.expensetracker.repository;

import com.tajutechgh.expensetracker.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    public Page<Transaction> findAllByUserId(int userId, Pageable pageable);
}
