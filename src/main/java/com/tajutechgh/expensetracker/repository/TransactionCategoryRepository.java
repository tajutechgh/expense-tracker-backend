package com.tajutechgh.expensetracker.repository;

import com.tajutechgh.expensetracker.entity.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Integer> {

    public List<TransactionCategory> findAllByUserId(int userId);
}
