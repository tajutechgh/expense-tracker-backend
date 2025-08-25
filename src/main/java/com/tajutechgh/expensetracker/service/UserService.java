package com.tajutechgh.expensetracker.service;

import com.tajutechgh.expensetracker.dto.UserDto;
import com.tajutechgh.expensetracker.entity.User;

import java.util.Optional;

public interface UserService {

    public UserDto getUserById(int userId);

    public UserDto getUserByEmail(String email);
}
