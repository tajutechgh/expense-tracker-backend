package com.tajutechgh.expensetracker.dto;

import com.tajutechgh.expensetracker.entity.User;

public class TransactionCategoryDto {

    private Integer id;
    private Integer userId;
    private String categoryName;
    private String categoryColor;

    public TransactionCategoryDto(){

    }

    public TransactionCategoryDto(Integer id, Integer userId, String categoryName, String categoryColor) {
        this.id = id;
        this.userId = userId;
        this.categoryName = categoryName;
        this.categoryColor = categoryColor;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryColor() {
        return categoryColor;
    }

    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
    }
}
