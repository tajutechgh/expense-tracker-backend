package com.tajutechgh.expensetracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name="transaction_categories")
public class TransactionCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="category_name", nullable = false)
    private String categoryName;

    @Column(name="category_color")
    private String categoryColor;

    public TransactionCategory(){

    }

    public TransactionCategory(Integer id, User user, String categoryName, String categoryColor) {
        this.id = id;
        this.user = user;
        this.categoryName = categoryName;
        this.categoryColor = categoryColor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "TransactionCategory{" +
                "id=" + id +
                ", user=" + user +
                ", categoryName='" + categoryName + '\'' +
                ", categoryColor='" + categoryColor + '\'' +
                '}';
    }
}
