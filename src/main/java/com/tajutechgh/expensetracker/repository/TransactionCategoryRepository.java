package com.tajutechgh.expensetracker.repository;

import com.tajutechgh.expensetracker.entity.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Integer> {

}
