package com.tajutechgh.expensetracker.repository;

import com.tajutechgh.expensetracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
}
