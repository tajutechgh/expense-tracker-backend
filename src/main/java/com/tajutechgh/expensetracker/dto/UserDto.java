package com.tajutechgh.expensetracker.dto;

import java.time.LocalDateTime;

public class UserDto {

    private Integer id;
    private String name;
    private String password;
    private String email;
    private LocalDateTime createdAt;

    public UserDto( ){

    }

    public UserDto(Integer id, String name, String password, String email, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
