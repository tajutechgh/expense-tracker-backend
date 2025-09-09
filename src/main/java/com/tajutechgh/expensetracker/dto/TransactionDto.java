package com.tajutechgh.expensetracker.dto;

import java.util.Date;

public class TransactionDto {

    private Integer id;
    private Integer userId;
    private Integer categoryId;
    private String transactionName;
    private double transactionAmount;
    private Date transactionDate;
    private String transactionType;

    public TransactionDto(){

    }

    public TransactionDto(Integer id, Integer userId, Integer categoryId, String transactionName, double transactionAmount, Date transactionDate, String transactionType) {
        this.id = id;
        this.userId = userId;
        this.categoryId = categoryId;
        this.transactionName = transactionName;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
