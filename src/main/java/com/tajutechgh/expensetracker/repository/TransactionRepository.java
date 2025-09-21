package com.tajutechgh.expensetracker.repository;

import com.tajutechgh.expensetracker.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    public Page<Transaction> findAllByUserId(int userId, Pageable pageable);

    public List<Transaction> findAllByUserIdAndTransactionDateBetweenOrderByTransactionDateDesc(int userId, LocalDate startDate, LocalDate endDate);

    @Query("SELECT DISTINCT YEAR(t.transactionDate) " +
            "FROM Transaction t " +
            "WHERE t.user.id = :userId " +
            "ORDER BY YEAR(t.transactionDate) DESC")
    public List<Integer> findDistinctYears(@Param("userId") int userId);

}
