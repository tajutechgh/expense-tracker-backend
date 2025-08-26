package com.tajutechgh.expensetracker.service;

import com.tajutechgh.expensetracker.dto.UserDto;
import com.tajutechgh.expensetracker.entity.User;

import java.util.Optional;

public interface UserService {

    public UserDto getUserById(int userId);

    public UserDto getUserByEmail(String email);

    public UserDto createUser(String name, String username, String password);
}
